package com.visionflix.core.presentation.ui.screen.home

import com.visionflix.core.domain.tv_model.Tv

data class TvState(
    val tvs: List<Tv> = emptyList(),
    val page: Int = 0,
    val totalPages: Int = 0,
    val error: String = "",
    val loading: Boolean = false
)