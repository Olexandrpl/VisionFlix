package com.visionflix.core.data.repostirory

import com.visionflix.core.data.remote.MovieApi
import com.visionflix.core.data.remote.movie_dto.PopularMoviesDto
import com.visionflix.core.data.remote.movie_dto.TrendingMoviesDto
import com.visionflix.core.data.remote.movie_dto.UpcomingMoviesDto
import com.visionflix.core.domain.repository.MovieRemoteRepository

class MovieRemoteRepositoryImpl(
    private val api: MovieApi
) : MovieRemoteRepository {
    override suspend fun getTrending(timeWindow: String, language: String): TrendingMoviesDto =
        api.getTrending(timeWindow, language)

    override suspend fun getUpcoming(language: String, page: Int): UpcomingMoviesDto =
        api.getUpcoming(language, page)

    override suspend fun getPopular(language: String, page: Int): PopularMoviesDto =
        api.getPopular(language, page)
}