package com.example.partysoul.network

import com.example.partysoul.models.ApiResponseHeader
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface JokeService {

    @GET("search")
    fun getJokes(@Header("Accept") accept: String): Call<ApiResponseHeader>
}