package com.example.applistproduct.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.applistproduct.models.Product

@Dao
interface ProductDao {

    @Query("SELECT * FROM Products")
    fun getAll():List<Product>

    @Insert
    fun insertProduct(vararg product:Product)

    @Delete
    fun deleteJoke(vararg product: Product)

    @Update
    fun update(vararg product: Product)
}