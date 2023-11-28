package com.visionflix.core.presentation.ui.screen.home

import androidx.lifecycle.ViewModel
import com.visionflix.core.domain.repository.MovieRemoteRepository
import com.visionflix.core.domain.use_case.HomeUseCase

class HomeViewModel(
    private val homeUseCase: HomeUseCase
) : ViewModel() {
}