package com.example.applistproduct.network

import com.example.applistproduct.models.ApiResponseHeader
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductService {

    @GET("search")
    fun getProducts(
        @Query("query")query:String,
        @Query("number") number: Int,
        @Query("apiKey") apiKey : String
    ): Call<ApiResponseHeader>
}