package com.example.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random



class MainActivity : AppCompatActivity() {

    val countries = arrayOf(
        "Argentina",
        "Bolivia",
        "Brasil",
        "Chile",
        "Colombia",
        "Ecuador",
        "Guyana",
        "Paraguay",
        "Peru",
        "Surinam",
        "Uruguay",
        "Venezuela"
    )

    val capitals = arrayOf(
        "Buenos Aires",
        "La Paz",
        "Brasilia",
        "Santiago",
        "Bogotá",
        "Quito",
        "Georgetown",
        "Asuncion",
        "Lima",
        "Paramaribo",
        "Montevideo",
        "Caracas"
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViews()
    }

    private fun loadQuestion(): Question {

        var positionCountries = getRandomNumberInRange()
        var positionCapitals = getRandomNumberInRange()

        var sentence =
            "¿Es " + capitals[positionCapitals] + " la capital de " + countries[positionCountries] + " ?"

        var answer = (positionCountries === positionCapitals)

        return Question(sentence, answer)
    }


    private fun setupViews(){

        val tvCountCorrect = findViewById<TextView>(R.id.tvCountCorrect)

        val tvCountIncorrect = findViewById<TextView>(R.id.tvCountIncorrect)

        val tvCountBlank = findViewById<TextView>(R.id.tvCountBlank)

        var correct = showSentence()

        val btNext = findViewById<Button>(R.id.btNext)

        val btYes =  findViewById<Button>(R.id.btYes)

        btYes.setOnClickListener {
            if (correct){
            Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show()
                countMe(tvCountCorrect)
            }
            else{
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show()
                countMe(tvCountIncorrect)
            }

            correct = showSentence()
        }

        val btNo = findViewById<Button>(R.id.btNo)

        btNo.setOnClickListener {
            if (!correct){
            Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show()
                countMe(tvCountCorrect)
            }
            else{
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show()
                countMe(tvCountIncorrect)
            }
            correct = showSentence()

        }

        btNext.setOnClickListener {
            countMe(tvCountBlank)
            showSentence()
        }

    }

    private fun showSentence(): Boolean{

        val tvSentence = findViewById<TextView>(R.id.tvSentence)

       var currentQuestion = loadQuestion()

        tvSentence.text = currentQuestion.sentence

        return currentQuestion.answer
    }

    private fun getRandomNumberInRange(): Int {
        return Random.nextInt(0, 12)
    }

    private fun countMe(textView: TextView) {
        // Get the text view

        // Get the value of the text view.
        val countString = textView.text.toString()

        // Convert value to a number and increment it
        var count = countString.toInt()
        count++

        // Display the new value in the text view.
        textView.text = count.toString()
    }


}