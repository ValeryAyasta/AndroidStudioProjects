package com.example.semana5sesion2networking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

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
        //codigo para que se muestre la información del servicio de API
       //en el textView

        //https://geek-jokes.sameerkumar.website/api?format=json

        //poner el codigo de retrofit



    }
}