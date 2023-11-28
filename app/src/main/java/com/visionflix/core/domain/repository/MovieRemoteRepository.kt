package com.visionflix.core.domain.repository

import com.visionflix.core.data.remote.movie_dto.PopularMoviesDto
import com.visionflix.core.data.remote.movie_dto.TrendingMoviesDto
import com.visionflix.core.data.remote.movie_dto.UpcomingMoviesDto

interface MovieRemoteRepository {
    suspend fun getTrending(
        timeWindow: String,
        language: String
    ): TrendingMoviesDto

    suspend fun getUpcoming(
        language: String,
        page: Int
    ): UpcomingMoviesDto

    suspend fun getPopular(
        language: String,
        page: Int
    ): PopularMoviesDto
}