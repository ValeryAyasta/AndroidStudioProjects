package com.example.partysoul.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.partysoul.models.Joke

/*
@Database(entities = arrayOf(Joke::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getDao() : JokeDao
    companion object{
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context : Context) : AppDatabase{
            if (INSTANCE == null){
                INSTANCE = Room
                    .databaseBuilder(context, AppDatabase::class.java, "party-soul.db")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE as AppDatabase
        }
    }

}*/