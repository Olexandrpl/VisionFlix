package com.visionflix.core.domain.movie_model

import com.visionflix.core.data.remote.movie_dto.DatesDto

data class UpcomingMovies(
    val datesDto: DatesDto,
    val page: Int,
    val movies: List<Movie>,
    val totalPages: Int,
)