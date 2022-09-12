package app.trian.testapp.ui.pages.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.trian.tes.component.screen.main.HomeUIState
import app.trian.tes.data.repository.design.TestRepository
import app.trian.tes.data.repository.design.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import logcat.LogPriority
import logcat.logcat
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val testRepository: TestRepository,
):ViewModel() {

    private var _listPemantau = MutableLiveData<HomeUIState>()
    val listPemantau get() = _listPemantau

    init {
        getListTest()
    }
    fun getListTest()=viewModelScope.launch {

        testRepository
            .getListTest()
            .onEach {

                _listPemantau.postValue(
                    HomeUIState(
                        loading = false,
                        error = false,
                        data = it
                    )
                )
            }
            .catch {

                _listPemantau.postValue(
                    HomeUIState(
                        loading = false,
                        error = true,
                        errorMessage = "${it.message}"
                    )
                )
            }
            .collect()
    }
}