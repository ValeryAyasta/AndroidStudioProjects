package com.example.partysoul.controller.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.partysoul.R
import com.example.partysoul.adapter.JokeAdapter
import com.example.partysoul.models.ApiResponseHeader
import com.example.partysoul.models.Joke
import com.example.partysoul.network.JokeService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Date

class JokesFragment : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvJokes = view.findViewById(R.id.rvJokes)

        loadJokes(view.context)

    }

    private fun loadJokes(context: Context) {
        //lamar a retrofit

        val url:String = "https://icanhazdadjoke.com/"

        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val jokeService : JokeService

        jokeService = retrofit.create(JokeService::class.java)

        val request = jokeService.getJokes("application/json")

        request.enqueue(object : Callback<ApiResponseHeader> {
            override fun onResponse(
                call: Call<ApiResponseHeader>,
                response: Response<ApiResponseHeader>
            ) {
                if (response.isSuccessful){
                    val jokes: List<Joke> = response.body()!!.results?: ArrayList()

                    println(System.currentTimeMillis())
                    print(Date().time)

                    jokes.map { joke: Joke -> joke.source = url }

                    rvJokes.layoutManager = LinearLayoutManager(context)
                    rvJokes.adapter = JokeAdapter(jokes, context)


                }
                else{
                    Log.d("Activity Fail", "Error: " + response.code())
                }
            }

            override fun onFailure(call: Call<ApiResponseHeader>, t: Throwable) {
                Log.d("Activity Fail", "Error: " + t.toString())
            }

        })


    }

    var jokes: List<Joke> = ArrayList()
    lateinit var rvJokes: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jokes, container, false)
    }

}