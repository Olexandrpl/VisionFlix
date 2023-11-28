package com.visionflix.core.data.remote.movie_dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.visionflix.core.domain.movie_model.PopularMovies

@JsonClass(generateAdapter = true)
data class PopularMoviesDto(
    @Json(name = "page")
    val page: Int,
    @Json(name = "results")
    val moviesDto: List<MovieDto>,
    @Json(name = "total_pages")
    val totalPages: Int,
    @Json(name = "total_results")
    val totalResults: Int
)

fun PopularMoviesDto.toPopularMovies(): PopularMovies =
    PopularMovies(page, moviesDto.map { it.toMovie() }, totalPages)
