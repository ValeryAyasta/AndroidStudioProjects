package com.example.applistproduct.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.applistproduct.models.Product

@Database(entities = arrayOf(Product::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getDao() : ProductDao
    companion object{
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context : Context) : AppDatabase{
            if (INSTANCE == null){
                INSTANCE = Room
                    .databaseBuilder(context, AppDatabase::class.java, "app-list-product.db")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE as AppDatabase
        }
    }

}