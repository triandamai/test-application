package app.trian.testapp.ui.pages.main

import androidx.lifecycle.ViewModel
import app.trian.tes.data.repository.design.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val userRepository: UserRepository
):ViewModel() {
    init {

    }

}