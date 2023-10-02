package com.example.partysoul.controller.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.partysoul.R
import com.example.partysoul.adapter.JokeAdapter
import com.example.partysoul.database.AppDatabase
import com.example.partysoul.models.Joke

class RatingJokesFragment : Fragment() {

    var jokes: List<Joke> = ArrayList()
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rating_jokes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        jokes = AppDatabase.getInstance(view.context).getDao().getAll()

        recyclerView = view.findViewById(R.id.rvJokeSave)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = JokeAdapter(jokes, view.context)
    }

}