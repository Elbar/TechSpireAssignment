package com.example.data.remote

import com.example.data.remote.dto.PointsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TechSpireApi {
    @GET("api/test/points")
    suspend fun getPoints(@Query("count") count: Int): PointsResponse
}
