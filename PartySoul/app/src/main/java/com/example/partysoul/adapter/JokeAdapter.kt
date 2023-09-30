package com.example.partysoul.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.partysoul.R
import com.example.partysoul.models.Joke

class JokeAdapter(val jokes: List<Joke>, val context: Context) : Adapter<JokeAdapter.ViewHolder>(){
    class ViewHolder (val view: View) : RecyclerView.ViewHolder(view) {
        val tvJoke = view.findViewById<TextView>(R.id.tvJoke)
        val tvSource = view.findViewById<TextView>(R.id.tvSource)
        val cvJoke  = view.findViewById<CardView>(R.id.cvJoke)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.prototype_joke, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return jokes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val joke = jokes[position]

        holder.tvJoke.text = joke.content;

        holder.tvSource.text = joke.source;

        //si hay imagen traerla acá (Picasso)
    }
}