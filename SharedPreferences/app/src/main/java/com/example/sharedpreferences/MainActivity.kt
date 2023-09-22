package com.example.sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Context
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btSave = findViewById<Button>(R.id.btSave)
        val btDelete = findViewById<Button>(R.id.button2)

        importPreferences()

        btSave.setOnClickListener {
            savePreferences()
        }

        btDelete.setOnClickListener {
            deletePreferences()
        }

    }

    private fun savePreferences() {

        val sharedPreferences = getSharedPreferences("credentials", Context.MODE_PRIVATE)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)

        val editor = sharedPreferences.edit()


        var email = etEmail.text.toString()

        var password = etPassword.text.toString()

        editor.putString("email", email).commit()
        editor.putString("password", password)



        val emailSaved = sharedPreferences.getString("email", "")
        val passwordSaved = sharedPreferences.getString("password", "")

        editor.apply()

        Toast.makeText(this, "Se guardaron los datos " + emailSaved + passwordSaved, Toast.LENGTH_LONG).show()
    }

    private fun importPreferences() {

        val sharedPreferences = this.getSharedPreferences("credentials", Context.MODE_PRIVATE)


        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)

        val emailSaved = sharedPreferences.getString("email", "")
        val passwordSaved = sharedPreferences.getString("password", "")

        if (emailSaved !== "" && passwordSaved !== "") {
            etEmail.setText(emailSaved)
            etPassword.setText(passwordSaved)

            Toast.makeText(this, "Se recuperaron los datos", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "No se encontraron datos guardados", Toast.LENGTH_LONG).show()
        }

    }

    private fun deletePreferences(){
        val sharedPreferences = this.getSharedPreferences("credentials", Context.MODE_PRIVATE)

        val editor = sharedPreferences.edit()
        editor.clear() // Elimina todos los valores
        editor.apply()

        Toast.makeText(this, "Se borraron los datos guardados", Toast.LENGTH_LONG).show()
    }
}