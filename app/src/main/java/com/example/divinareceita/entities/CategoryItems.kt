package com.example.divinareceita.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class CategoryItems (
    @Expose
    @SerializedName("idCategory")
    val idCategory: String,
    @Expose
    @SerializedName("strCategory")
    val strCategory: String,
    @Expose
    @SerializedName("strCategoryThumb")
    val strCategoryThumb: String,
    @Expose
    @SerializedName("strCategoryDescription")
    val strCategoryDescription: String
)

