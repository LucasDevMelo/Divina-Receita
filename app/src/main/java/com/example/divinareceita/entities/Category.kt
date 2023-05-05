package com.example.divinareceita.entities

import androidx.room.*
import com.example.divinareceita.entities.converter.CategoryListConverter
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Category")
data class Category (
    @PrimaryKey(autoGenerate = true)
    var id:Int,

    @ColumnInfo(name = "categoriesitems")
    @Expose
    @SerializedName("categories")
    @TypeConverters(CategoryListConverter::class)
    val categoriesitems: List<CategoryItems>? = null
)
