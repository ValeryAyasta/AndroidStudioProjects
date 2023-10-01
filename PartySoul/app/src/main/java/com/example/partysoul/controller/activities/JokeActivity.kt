package com.example.partysoul.controller.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.partysoul.R
import com.example.partysoul.controller.fragments.JokesFragment
import com.example.partysoul.controller.fragments.RatingJokesFragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView

class JokeActivity : AppCompatActivity() {

    //hacer la llamada de navegación
    private val onNavigationItemSelectedListener = BottomNavigationView
        .OnNavigationItemSelectedListener { item ->  navigateTo(item)}

    private fun navigateTo(item: MenuItem) : Boolean {
        item.isChecked = true

        return supportFragmentManager
            .beginTransaction()
            .replace(R.id.flFragments, getFragmentFor(item))
            .commit() > 0
    }

    private fun getFragmentFor(item: MenuItem): Fragment {
       return when(item.itemId){
           R.id.menu_favourites -> RatingJokesFragment()
           R.id.menu_all -> JokesFragment()
           else -> JokesFragment()
       }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joke)

        val navView:BottomNavigationView = findViewById(R.id.bnvMenu)
        navView.setOnNavigationItemSelectedListener ( onNavigationItemSelectedListener )
        navigateTo(navView.menu.findItem(R.id.menu_all))
    }
}