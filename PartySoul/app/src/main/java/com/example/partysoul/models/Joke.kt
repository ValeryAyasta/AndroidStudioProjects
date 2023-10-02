package com.example.partysoul.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.Calendar
import java.util.Date

@Entity(tableName = "jokes")
class Joke(

    @PrimaryKey(autoGenerate = true)
    val index:Int=0,

    var rating: Float,

    @SerializedName("id")
    val joke_id:String,

    @SerializedName("joke")
    val content: String,

    var source:String? =null,

):Serializable