package com.example.appsemana5sesion1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    var contacts = ArrayList<Contact>()

    var contactAdapter = ContactAdapter(contacts)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadContacts()

        initView()
    }

    private fun initView(){
        val rvContact = findViewById<RecyclerView>(R.id.rvContact)

        rvContact.adapter = contactAdapter
        rvContact.layoutManager = LinearLayoutManager(this)
    }

    private fun loadContacts() {
        contacts.add(Contact("Lucho Lopez", "123456789"))
        contacts.add(Contact("Lucia Lopez", "123400789"))
        contacts.add(Contact("Luz Lopez", "123456789"))
        contacts.add(Contact("Lucas Lopez", "123456700"))
        contacts.add(Contact("Luna Lopez", "120056789"))
    }


}