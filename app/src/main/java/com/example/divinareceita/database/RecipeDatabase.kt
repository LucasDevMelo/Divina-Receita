package com.example.divinareceita.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.divinareceita.dao.RecipeDao
import com.example.divinareceita.entities.Recipies

@Database(entities = [Recipies::class], version = 1, exportSchema = false)
abstract class RecipeDatabase: RoomDatabase() {

    companion object{

        var recipesDatabase:RecipeDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): RecipeDatabase{
            if (recipesDatabase != null){
                recipesDatabase = Room.databaseBuilder(
                    context,
                    RecipeDatabase::class.java,
                    "recipe.db"
                ).build()
            }
            return  recipesDatabase!!
        }
    }

    abstract fun recipeDao(): RecipeDao
}