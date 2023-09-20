package com.example.semana6sesion1.models

import androidx.room.Entity

@Entity
class Contact (
    val id: Int,
    val name:String,
    val telephone:String
)