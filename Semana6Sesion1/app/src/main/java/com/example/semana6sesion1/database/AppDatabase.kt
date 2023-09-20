package com.example.semana6sesion1.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.semana6sesion1.models.Contact

@Database(entities = arrayOf(Contact::class), version = 1)
abstract class AppDatabase : RoomDatabase()
{

}