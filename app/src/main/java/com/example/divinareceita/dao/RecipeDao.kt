package com.example.divinareceita.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.divinareceita.entities.Category
import com.example.divinareceita.entities.Recipes

@Dao
interface RecipeDao {
    @get:Query("SELECT * FROM category ORDER BY id DESC")
    val getAllCategory: List<Category>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategory(category: Category)
}