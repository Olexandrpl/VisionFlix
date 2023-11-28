package com.visionflix.core.domain.tv_model

data class TrendingTv(
    val page: Int,
    val tvs: List<Tv>,
    val totalPages: Int,
)
