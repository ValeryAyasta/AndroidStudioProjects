package com.example.partysoul

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadJokes()
    }


    private fun loadJokes() {
        val rvJokes = findViewById<RecyclerView>(R.id.rvJokes)

        //lamar a retrofit

        val retrofit = Retrofit.Builder()
            .baseUrl("https://icanhazdadjoke.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val jokeService : JokeService
    }
}