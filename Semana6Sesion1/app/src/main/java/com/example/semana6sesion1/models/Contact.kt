package com.example.semana6sesion1.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Contact (

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo //( name = "apellido-nombre")
    val name:String,

    @ColumnInfo
    val telephone:String
)