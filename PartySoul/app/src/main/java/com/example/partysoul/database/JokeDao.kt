package com.example.partysoul.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.partysoul.models.Joke

@Dao
interface JokeDao {

    @Query("SELECT * FROM Jokes")
    fun getAll() : List<Joke>

    @Insert
    fun insertJoke(vararg jokes: Joke)

    @Delete
    fun deleteJoke(vararg jokes: Joke)

    @Update
    fun update(vararg jokes: Joke)
}