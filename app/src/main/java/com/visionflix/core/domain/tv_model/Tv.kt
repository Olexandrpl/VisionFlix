package com.visionflix.core.domain.tv_model

import com.squareup.moshi.Json

data class Tv(
    val adult: Boolean,
    val backdropPath: String?,
    val firstAirDate: String,
    val genreIds: List<Int>,
    val id: Int,
    val name: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String?,
    val voteAverage: Double,
    val voteCount: Int
)
