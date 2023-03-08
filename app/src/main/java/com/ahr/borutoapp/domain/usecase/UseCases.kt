package com.ahr.borutoapp.domain.usecase

import com.ahr.borutoapp.domain.usecase.read_onboarding.ReadOnBoardingUseCase
import com.ahr.borutoapp.domain.usecase.save_onboarding.SaveOnBoardingUseCase

data class UseCases(
    val readOnBoardingUseCase: ReadOnBoardingUseCase,
    val saveOnBoardingUseCase: SaveOnBoardingUseCase
)