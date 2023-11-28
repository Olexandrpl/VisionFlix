package com.visionflix.core.data.remote

import com.visionflix.common.Constants
import com.visionflix.core.data.remote.movie_dto.PopularMoviesDto
import com.visionflix.core.data.remote.movie_dto.TrendingMoviesDto
import com.visionflix.core.data.remote.movie_dto.UpcomingMoviesDto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.Locale

interface MovieApi {

    @Headers(
        "Authorization: ${Constants.ACCESS_TOKEN}",
        "accept: application/json"
    )
    @GET("3/trending/movie/{time_window}")
    suspend fun getTrending(
        @Path("time_window") timeWindow: String = "day",
        @Query("language") language: String = Locale.getDefault().toLanguageTag()
    ): TrendingMoviesDto

    @Headers(
        "Authorization: ${Constants.ACCESS_TOKEN}",
        "accept: application/json"
    )
    @GET("3/movie/upcoming")
    suspend fun getUpcoming(
        @Query("language") language: String = Locale.getDefault().toLanguageTag(),
        @Query("page") page: Int
    ): UpcomingMoviesDto

    @Headers(
        "Authorization: ${Constants.ACCESS_TOKEN}",
        "accept: application/json"
    )
    @GET("3/movie/popular")
    suspend fun getPopular(
        @Query("language") language: String = Locale.getDefault().toLanguageTag(),
        @Query("page") page: Int
    ): PopularMoviesDto

}