package com.example.appfootball.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.appfootball.R
import com.example.appfootball.models.Team
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso

class TeamAdapter (val teams: List<Team>, val context: Context):
    RecyclerView.Adapter<TeamAdapter.ViewHolder>() {
    class ViewHolder (val view : View): RecyclerView.ViewHolder(view){
        val ivLogo = view.findViewById<ImageView>(R.id.ivLogo)
        val tvName = view.findViewById<TextView>(R.id.tvName)
        val cvTeam = view.findViewById<CardView>(R.id.cvTeam)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.prototype_team, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return teams.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val team = teams[position]
        holder.tvName.text = team.name

        val picassoBuilder = Picasso.Builder(context)
        picassoBuilder.downloader(OkHttp3Downloader(context))
        picassoBuilder.build().load(team.logo)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(holder.ivLogo)
    }
}