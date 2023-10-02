package com.example.applistproduct.controller.activities

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.applistproduct.R
import com.example.applistproduct.controller.fragments.FavouriteFragment
import com.example.applistproduct.controller.fragments.HomeFragment
import com.example.applistproduct.controller.fragments.ProductFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    //hacer la llamada de navegación
    private val onNavigationItemSelectedListener = BottomNavigationView
        .OnNavigationItemSelectedListener { item ->  navigateTo(item)}

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView:BottomNavigationView = findViewById(R.id.bnvMenu)
        navView.setOnNavigationItemSelectedListener ( onNavigationItemSelectedListener )
        navigateTo(navView.menu.findItem(R.id.menu_home))


    }

    private fun navigateTo(item: MenuItem) : Boolean {
        item.isChecked = true

        return supportFragmentManager
            .beginTransaction()
            .replace(R.id.flFragments, getFragmentFor(item))
            .commit() > 0
    }

    private fun getFragmentFor(item: MenuItem): Fragment {
        return when(item.itemId){
            R.id.menu_home -> HomeFragment()
            R.id.menu_products -> ProductFragment()
            R.id.menu_favorites -> FavouriteFragment()
            else -> HomeFragment()
        }
    }




}