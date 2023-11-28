package com.visionflix.core.data.remote.movie_dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.visionflix.core.domain.movie_model.TrendingMovies

@JsonClass(generateAdapter = true)
data class TrendingMoviesDto(
    @Json(name = "page")
    val page: Int,
    @Json(name = "results")
    val moviesDto: List<MovieDto>,
    @Json(name = "total_pages")
    val totalPages: Int,
    @Json(name = "total_results")
    val totalResults: Int
)

fun TrendingMoviesDto.toTrendingMovies(): TrendingMovies =
    TrendingMovies(page, moviesDto.map { it.toMovie() }, totalPages)