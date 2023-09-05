package com.example.appsemana3repaso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

const val EXTRA_MESS = "com.example.appsemana3repaso"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //lo normal es vincular el componente XML con la lógica
    //mediante findViewById
    fun sendMessage(view : View){
        val editText = findViewById<EditText>(R.id.etName)
        var message = editText.text.toString();

        //se accede al contenido del editText con el método .text

        //intent: enviar una información a otro activity

        val intent = Intent(this, DisplayMessageActivity::class.java).apply {
            putExtra(EXTRA_MESS, message)
        } //recibe el contexto (en este caso this) y la clase

        startActivity(intent);
    }
}