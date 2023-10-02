package com.example.applistproduct.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "products")
class Product (

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    val id: Long,

    @SerializedName("title")
    val title: String,


    @SerializedName("image")
    val image: String

):Serializable