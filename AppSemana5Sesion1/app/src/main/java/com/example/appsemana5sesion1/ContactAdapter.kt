package com.example.appsemana5sesion1

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
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

class ContactPrototype(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val tvName = itemView.findViewById<TextView>(R.id.tvName)

    val tvTelephone = itemView.findViewById<TextView>(R.id.tvTelephone)

    fun bind(contact: Contact){
        tvName.text = contact.name
        tvTelephone.text = contact.telephone
    }



}
