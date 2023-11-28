package com.visionflix.core.data.repostirory

import com.visionflix.core.data.remote.TvApi
import com.visionflix.core.data.remote.tv_dto.TrendingTvDto
import com.visionflix.core.domain.repository.TvRemoteRepository

class TvRemoteRepositoryImpl(
    private val api: TvApi
) : TvRemoteRepository {
    override suspend fun getTrending(timeWindow: String, language: String): TrendingTvDto =
        api.getTrending(
            timeWindow,
            language
        )

}