package com.example.partysoul.controller.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.partysoul.R
import com.example.partysoul.database.AppDatabase
import com.example.partysoul.models.Joke


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvBestJoke = findViewById<TextView>(R.id.tvBestJoke)

        val jokes = AppDatabase.getInstance(this).getDao().getAll()

            val bestJoke = jokes.maxByOrNull { it.rating }

        if (bestJoke != null){
            tvBestJoke.text = bestJoke.content
        }
        else{
            tvBestJoke.text = "No Jokes Yet!"
        }

        val btJokes = findViewById<Button>(R.id.btJokes)



        btJokes.setOnClickListener {
            val intent = Intent(this, JokeActivity::class.java)
            startActivity(intent)
        }

    }

}