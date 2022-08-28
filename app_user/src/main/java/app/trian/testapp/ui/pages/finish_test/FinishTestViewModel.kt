package app.trian.testapp.ui.pages.finish_test

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FinishTestViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) :ViewModel(){
}