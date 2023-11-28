package com.visionflix.core.data.remote.tv_dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.visionflix.core.domain.tv_model.TrendingTv

@JsonClass(generateAdapter = true)
data class TrendingTvDto(
    @Json(name = "page")
    val page: Int,
    @Json(name = "results")
    val tvsDto: List<TvDto>,
    @Json(name = "total_pages")
    val totalPages: Int,
    @Json(name = "total_results")
    val totalResults: Int
)

fun TrendingTvDto.toTrendingTv(): TrendingTv =
    TrendingTv(page, tvsDto.map { it.toTv() }, totalPages)