package com.visionflix.core.domain.movie_model

data class PopularMovies(
    val page: Int,
    val movies: List<Movie>,
    val totalPages: Int,
)