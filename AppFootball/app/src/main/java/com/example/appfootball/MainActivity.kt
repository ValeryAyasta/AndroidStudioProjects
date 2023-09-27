package com.example.appfootball

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appfootball.adapter.TeamAdapter
import com.example.appfootball.models.ApiResponseHeader
import com.example.appfootball.models.Team
import com.example.appfootball.networking.TeamService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var teamRecyclerView: RecyclerView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        teamRecyclerView = findViewById(R.id.rvTeams)

        loadTeams(this)

    }

    private fun loadTeams(context: Context) {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api-football-v1.p.rapidapi.com/v2/teams/league/1")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val teamService: TeamService

        teamService = retrofit.create(TeamService::class.java)

        val request = teamService.getTeams(
            "api-football-v1.p.rapidapi.com/",
            "0bee96e232msh91abfc697a99ee1p1f3b1fjsn3694ca9ffc56"
        )

        request.enqueue( object : Callback<ApiResponseHeader>{
            override fun onResponse(
                call: Call<ApiResponseHeader>,
                response: Response<ApiResponseHeader>
            ) {
                if(response.isSuccessful){
                    val teams : List<Team> = response.body()!!.api.teams

                    teamRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                    teamRecyclerView.adapter = TeamAdapter(teams, context)
                }
            }

            override fun onFailure(call: Call<ApiResponseHeader>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })


    }
}