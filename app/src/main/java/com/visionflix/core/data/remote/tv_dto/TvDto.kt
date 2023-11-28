package com.visionflix.core.data.remote.tv_dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.visionflix.core.domain.tv_model.Tv

@JsonClass(generateAdapter = true)
data class TvDto(
    @Json(name = "adult")
    val adult: Boolean,
    @Json(name = "backdrop_path")
    val backdropPath: String,
    @Json(name = "first_air_date")
    val firstAirDate: String,
    @Json(name = "genre_ids")
    val genreIds: List<Int>,
    @Json(name = "id")
    val id: Int,
    @Json(name = "media_type")
    val mediaType: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "origin_country")
    val originCountry: List<String>,
    @Json(name = "original_language")
    val originalLanguage: String,
    @Json(name = "original_name")
    val originalName: String,
    @Json(name = "overview")
    val overview: String,
    @Json(name = "popularity")
    val popularity: Double,
    @Json(name = "poster_path")
    val posterPath: String,
    @Json(name = "vote_average")
    val voteAverage: Double,
    @Json(name = "vote_count")
    val voteCount: Int
)

fun TvDto.toTv(): Tv =
    Tv(
        adult,
        backdropPath,
        firstAirDate,
        genreIds,
        id,
        name,
        overview,
        popularity,
        posterPath,
        voteAverage,
        voteCount
    )