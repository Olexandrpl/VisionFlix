package com.visionflix.core.domain.use_case

import com.visionflix.common.Resources
import com.visionflix.core.data.remote.movie_dto.toPopularMovies
import com.visionflix.core.data.remote.movie_dto.toTrendingMovies
import com.visionflix.core.data.remote.movie_dto.toUpcomingMovies
import com.visionflix.core.data.remote.tv_dto.toTrendingTv
import com.visionflix.core.domain.movie_model.PopularMovies
import com.visionflix.core.domain.movie_model.TrendingMovies
import com.visionflix.core.domain.movie_model.UpcomingMovies
import com.visionflix.core.domain.repository.MovieRemoteRepository
import com.visionflix.core.domain.repository.TvRemoteRepository
import com.visionflix.core.domain.tv_model.TrendingTv
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class HomeUseCase(
    private val movieRep: MovieRemoteRepository,
    private val tvRep: TvRemoteRepository
) {
    fun getTrendingMovies(timeZone: String, language: String): Flow<Resources<TrendingMovies>> =
        flow {
            try {
                emit(Resources.Loading())
                val response = movieRep.getTrending(timeZone, language).toTrendingMovies()
                emit(Resources.Success(response))
            } catch (e: HttpException) {
                emit(Resources.Error(e.localizedMessage ?: "Couldn`t connected to the internet"))
            } catch (e: Exception) {
                emit(Resources.Error(e.message ?: "An unexpected message occurred"))
            }
        }

    fun getUpcomingMovies(language: String, page: Int): Flow<Resources<UpcomingMovies>> =
        flow {
            try {
                emit(Resources.Loading())
                val response = movieRep.getUpcoming(language, page).toUpcomingMovies()
                emit(Resources.Success(response))
            } catch (e: HttpException) {
                emit(Resources.Error(e.localizedMessage ?: "Couldn`t connected to the internet"))
            } catch (e: Exception) {
                emit(Resources.Error(e.message ?: "An unexpected message occurred"))
            }
        }

    fun getPopularMovies(language: String, page: Int): Flow<Resources<PopularMovies>> =
        flow {
            try {
                emit(Resources.Loading())
                val response = movieRep.getPopular(language, page).toPopularMovies()
                emit(Resources.Success(response))
            } catch (e: HttpException) {
                emit(Resources.Error(e.localizedMessage ?: "Couldn`t connected to the internet"))
            } catch (e: Exception) {
                emit(Resources.Error(e.message ?: "An unexpected message occurred"))
            }
        }

    fun getTrendingTv(timeZone: String, language: String): Flow<Resources<TrendingTv>> =
        flow {
            try {
                emit(Resources.Loading())
                val response = tvRep.getTrending(timeZone, language).toTrendingTv()
                emit(Resources.Success(response))
            } catch (e: HttpException) {
                emit(Resources.Error(e.localizedMessage ?: "Couldn`t connected to the internet"))
            } catch (e: Exception) {
                emit(Resources.Error(e.message ?: "An unexpected message occurred"))
            }
        }
}