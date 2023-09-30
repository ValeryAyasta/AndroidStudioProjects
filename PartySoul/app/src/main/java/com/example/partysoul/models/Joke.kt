package com.example.partysoul.models

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity
class Joke (

    @SerializedName("joke")
    val joke: String


):Serializable