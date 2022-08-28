package app.trian.testapp.ui.pages.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.trian.tes.data.repository.design.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    fun isUserAlreadyLoggedIn(
        cb:(Boolean)->Unit
    )=viewModelScope.launch {
        cb(userRepository.isUserLoggedIn())
    }

}