package com.example.partysoul.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity
class Joke (

    @PrimaryKey(autoGenerate = true)
    val id:Int,

    @SerializedName("source")
    val source:String,

    @SerializedName("joke_id")
    val joke_id:String,

    @SerializedName("content")
    val content: String,

    @SerializedName("rating")
    val rating: Float,

    @ColumnInfo(name = "created_at")
    val createdAt: Long = System.currentTimeMillis()


):Serializable