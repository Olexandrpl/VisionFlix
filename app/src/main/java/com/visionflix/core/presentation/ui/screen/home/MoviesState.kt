package com.visionflix.core.presentation.ui.screen.home

import com.visionflix.core.domain.movie_model.Movie

data class MoviesState(
    val movies: List<Movie> = emptyList(),
    val page: Int = 0,
    val totalPages: Int = 0,
    val error: String = "",
    val loading: Boolean = false
)
