package com.example.semana5sesion2networking

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface JokeService {
    @GET("api") //la ruta del url
    fun getJoke(@Query("format") format:String) : Call<Joke>

}