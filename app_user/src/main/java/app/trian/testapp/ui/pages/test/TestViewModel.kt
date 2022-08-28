package app.trian.testapp.ui.pages.test

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TestViewModel @Inject constructor(
   private val savedStateHandle: SavedStateHandle
):ViewModel() {
}