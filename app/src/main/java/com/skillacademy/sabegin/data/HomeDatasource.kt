package com.skillacademy.sabegin.data

import com.skillacademy.sabegin.BuildConfig
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeDatasource {

    @GET("/3/discover/movie")
    fun doscoverMovie(
        @Query("api_key")
        apiKey:String= BuildConfig.TMDB_API_KEY
    ): Single<HomeResponse>
}