package app.trian.testapp.ui.pages.detail_test

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.trian.tes.component.Routes
import app.trian.tes.component.screen.DetailTestUIState
import app.trian.tes.component.screen.main.HomeUIState
import app.trian.tes.data.repository.design.TestRepository
import app.trian.tes.data.utils.utils.formatReadableDate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailTestViewModel @Inject constructor(
    private val savedStateHandle:SavedStateHandle,
    private val testRepository: TestRepository
) :ViewModel() {
    private var _detailTest = MutableLiveData<DetailTestUIState>()
    val detailTest get() = _detailTest

    init {
        val testUID = savedStateHandle.get<String>(Routes.DetailTest.argKey).orEmpty()
        getDetailTest(testUID)
    }

    fun getDetailTest(testUID:String)=viewModelScope.launch {
        testRepository
            .getDetailTest(testUID)
            .onEach {
                _detailTest.postValue(
                    DetailTestUIState(
                        loading = false,
                        error = false,
                        title = it.title,
                        description = it.description,
                        createdAt = it.createdAt.formatReadableDate(),
                        creator = it.creator
                    )
                )
            }
            .catch {
                _detailTest.postValue(
                    DetailTestUIState(
                        loading = false,
                        error = true,
                        errorMessage = "${it.message}"
                    )
                )
            }
            .collect()
    }
}