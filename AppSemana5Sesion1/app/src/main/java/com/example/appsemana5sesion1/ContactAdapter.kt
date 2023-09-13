package com.example.appsemana5sesion1

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter

class ContactAdapter(var contacts: ArrayList<Contact>): Adapter<ContactPrototype>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactPrototype {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ContactPrototype, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

}
