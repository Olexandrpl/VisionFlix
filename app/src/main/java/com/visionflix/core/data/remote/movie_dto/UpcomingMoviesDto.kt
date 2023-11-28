package com.visionflix.core.data.remote.movie_dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.visionflix.core.domain.movie_model.UpcomingMovies

@JsonClass(generateAdapter = true)
data class UpcomingMoviesDto(
    @Json(name = "dates")
    val datesDto: DatesDto,
    @Json(name = "page")
    val page: Int,
    @Json(name = "results")
    val moviesDto: List<MovieDto>,
    @Json(name = "total_pages")
    val totalPages: Int,
    @Json(name = "total_results")
    val totalResults: Int
)

fun UpcomingMoviesDto.toUpcomingMovies(): UpcomingMovies =
    UpcomingMovies(datesDto, page, moviesDto.map { it.toMovie() }, totalPages)