package com.ahr.borutoapp.domain.usecase.save_onboarding

import com.ahr.borutoapp.data.repository.Repository

class SaveOnBoardingUseCase(
    private val repository: Repository
) {

    suspend operator fun invoke(completed: Boolean) {
        repository.saveOnBoardingState(completed)
    }

}