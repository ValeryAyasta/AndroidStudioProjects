package com.example.partysoul.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.partysoul.R
import com.example.partysoul.database.AppDatabase
import com.example.partysoul.models.Joke

class JokeAdapter(val jokes: List<Joke>, val context: Context) : Adapter<JokeAdapter.ViewHolder>(){
    class ViewHolder (val view: View) : RecyclerView.ViewHolder(view) {
        val tvJoke = view.findViewById<TextView>(R.id.tvJoke)
        val tvSource = view.findViewById<TextView>(R.id.tvSource)
        val rbRating = view.findViewById<RatingBar>(R.id.rbRating)
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

        var joke = jokes[position]

        holder.tvJoke.text = joke.content;

        holder.tvSource.text = joke.source;

        //si hay imagen traerla acá (Picasso)

        val dao = AppDatabase.getInstance(context).getDao()

        val existingJoke = dao.getAll().find { j : Joke -> j.content == joke.content }

        if (existingJoke != null){
            holder.rbRating.rating = existingJoke.rating
        }
        else{
            holder.rbRating.rating = joke.rating
        }

        holder.rbRating.setOnRatingBarChangeListener { _, rating, _ ->

               if (existingJoke != null) {
                   existingJoke.rating = rating
                   dao.update(existingJoke)
                   Toast.makeText(context, "Updated!", Toast.LENGTH_SHORT).show()
               }
                else{
                   joke.rating = rating
                   dao.insertJoke(joke)
                   Toast.makeText(context, "Added!", Toast.LENGTH_SHORT).show()
               }

        }

    }



}