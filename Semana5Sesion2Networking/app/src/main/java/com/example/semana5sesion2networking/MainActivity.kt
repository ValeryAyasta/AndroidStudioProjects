package com.example.semana5sesion2networking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btJoke = findViewById<Button>(R.id.btJoke)

        btJoke.setOnClickListener {
            loadJoke()
        }

    }

    private fun loadJoke() {

        val tvJoke = findViewById<TextView>(R.id.tvJoke)
        //codigo para que se muestre la información del servicio de API
       //en el textView

        //https://geek-jokes.sameerkumar.website/api?format=json

        //poner el codigo de retrofit , crear instancia de Retrofit

        val retrofit = Retrofit.Builder()

            .baseUrl("https://geek-jokes.sameerkumar.website/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        //crear instancia d ela interfaz

        val jokeService:JokeService
        jokeService = retrofit.create(JokeService::class.java)


        //crear ima variable y asigno el servicio

        val request = jokeService.getJoke("json")

        request.enqueue(object  : Callback<Joke>{
            override fun onResponse(call: Call<Joke>, response: Response<Joke>) {
                //gestion si todo sale bien

                if (response.isSuccessful){
                    //vincular con el textView
                    tvJoke.text = response.body()!!.joke

                }
            }

            override fun onFailure(call: Call<Joke>, t: Throwable) {
                //gestion si falla, sale mal


            }

        })

    }
}