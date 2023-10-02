package com.example.applistproduct.models

import com.google.gson.annotations.SerializedName

class ApiResponseHeader (

    @SerializedName("products")
    val products: List<Product>
)
