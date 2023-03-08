package com.ahr.borutoapp.presentation.screen.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahr.borutoapp.domain.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    private val _readOnBoardingState = MutableStateFlow(false)
    val readOnBoardingState: StateFlow<Boolean> get() = _readOnBoardingState

    init {
        viewModelScope.launch(Dispatchers.IO) {
            useCases.readOnBoardingUseCase.invoke().collectLatest { complete ->
                _readOnBoardingState.value = complete
            }
        }
    }

}