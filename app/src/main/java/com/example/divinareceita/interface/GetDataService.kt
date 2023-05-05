package com.example.divinareceita.`interface`

import com.example.divinareceita.entities.Category
import retrofit2.Call
import retrofit2.http.GET

interface GetDataService {
    @GET("/category.php")
    fun getCategoryList(): Call<List<Category>>
}