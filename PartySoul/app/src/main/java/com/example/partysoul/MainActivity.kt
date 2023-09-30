package com.example.partysoul

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.ConsoleMessage
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.partysoul.adapter.JokeAdapter
import com.example.partysoul.models.ApiResponseHeader
import com.example.partysoul.models.Joke
import com.example.partysoul.network.JokeService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.Console
import java.util.Date

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadJokes(this)
    }


    private fun loadJokes(context : Context) {
        val rvJokes = findViewById<RecyclerView>(R.id.rvJokes)

        //lamar a retrofit

        val url:String = "https://icanhazdadjoke.com/"

        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val jokeService : JokeService

        jokeService = retrofit.create(JokeService::class.java)

        val request = jokeService.getJokes("application/json")

        request.enqueue(object : Callback<ApiResponseHeader>{
            override fun onResponse(
                call: Call<ApiResponseHeader>,
                response: Response<ApiResponseHeader>
            ) {
                if (response.isSuccessful){
                    val jokes: List<Joke> = response.body()!!.results?: ArrayList()

                    println(System.currentTimeMillis())
                    print(Date().time)

                    jokes.map { joke: Joke -> joke.source = url }

                    rvJokes.layoutManager = LinearLayoutManager(this@MainActivity)
                    rvJokes.adapter = JokeAdapter(jokes, context)


                }
            }

            override fun onFailure(call: Call<ApiResponseHeader>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }
}