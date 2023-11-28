package com.visionflix.core.data.remote

import com.visionflix.common.Constants
import com.visionflix.core.data.remote.tv_dto.TrendingTvDto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface TvApi {
    @Headers(
        "Authorization: ${Constants.ACCESS_TOKEN}",
        "accept: application/json"
    )
    @GET("3/trending/tv/{time_window}")
    suspend fun getTrending(
        @Path("time_window") timeWindow: String,
        @Query("language") language: String
    ): TrendingTvDto


}