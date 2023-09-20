package com.example.semana6sesion1.adapter

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.semana6sesion1.models.Contact

@Dao
interface ContactDao {
    //Room trabaja con List, no con ArrayList

    @Query("SELECT * FROM Contact")
    fun getAll(): List<Contact>

    @Insert
    fun insertContact(vararg contacts: Contact)

    @Delete
    fun deleteContact(vararg contacts: Contact)

    @Update
    fun updateContact(vararg contacts: Contact)
}