package com.example.divinareceita.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Category (
    @Expose
    @SerializedName("categories")
    val categoriesitems: List<CategoryItems>
)
