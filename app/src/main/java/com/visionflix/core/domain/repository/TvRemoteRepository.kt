package com.visionflix.core.domain.repository

import com.visionflix.core.data.remote.tv_dto.TrendingTvDto
import java.util.Locale

interface TvRemoteRepository {
    suspend fun getTrending(
        timeWindow: String,
        language: String
    ): TrendingTvDto
}