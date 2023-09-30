package com.example.partysoul.models

import com.google.gson.annotations.SerializedName

class ApiResponseHeader (

    @SerializedName("results")
    val results : List<Joke>
)