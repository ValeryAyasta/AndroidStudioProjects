package com.example.semana6sesion1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.semana6sesion1.database.AppDatabase
import com.example.semana6sesion1.models.Contact

class MainActivity : AppCompatActivity() {

    lateinit var contacts : List<Contact>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadContacts()
    }

    private fun loadContacts() {
       contacts = AppDatabase.getInstance(this).getDao().getAll()
    }
}