package app.trian.testapp.ui.pages.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.trian.tes.data.repository.design.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    fun register(
        email:String,
        password:String,
        name:String,
        callback:(Boolean,String)->Unit
    )=viewModelScope.launch {
        userRepository.register(
            email,
            password,
            name
        )
            .catch {
                callback(false,"${it.message}")
            }
            .onEach {
                callback(it.first,it.second)
            }
            .collect()
    }
}