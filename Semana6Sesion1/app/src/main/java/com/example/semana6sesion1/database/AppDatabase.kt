package com.example.semana6sesion1.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.semana6sesion1.adapter.ContactDao
import com.example.semana6sesion1.models.Contact

@Database(entities = arrayOf(Contact::class), version = 1)
abstract class AppDatabase : RoomDatabase()
{
    //usamos el patron "singleton"

    abstract fun getDao() : ContactDao
    companion object{
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context : Context) : AppDatabase{
            if (INSTANCE == null){
                INSTANCE = Room
                    .databaseBuilder(context, AppDatabase::class.java, "mycontact.db")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE as AppDatabase
        }
    }
}