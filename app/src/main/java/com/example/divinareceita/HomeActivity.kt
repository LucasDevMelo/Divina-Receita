package com.example.divinareceita

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.divinareceita.adapter.MainCategoryAdapter
import com.example.divinareceita.adapter.SubCategoryAdapter
import com.example.divinareceita.entities.Recipes

class HomeActivity : AppCompatActivity() {
    var arrMainCategory = ArrayList<Recipes>()
    var arrSubCategory = ArrayList<Recipes>()
    var mainCategoryAdapter = MainCategoryAdapter()
    var subCategoryAdapter = SubCategoryAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //temporary data
        arrMainCategory.add(Recipes(1, "Beef"))
        arrMainCategory.add(Recipes(2, "Chicken"))
        arrMainCategory.add(Recipes(3, "Dessert"))
        arrMainCategory.add(Recipes(4, "Lamb"))

        mainCategoryAdapter.setData(arrMainCategory)

        arrSubCategory.add(Recipes(1, "Beef and mustard pie"))
        arrSubCategory.add(Recipes(2, "Chicken and mushroom hotpot"))
        arrSubCategory.add(Recipes(3, "Dessert pancakes"))
        arrSubCategory.add(Recipes(4, "kapsalon"))

        subCategoryAdapter.setData((arrSubCategory))

        findViewById<RecyclerView>(R.id.rv_main_category).layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        findViewById<RecyclerView>(R.id.rv_main_category).adapter = mainCategoryAdapter

        findViewById<RecyclerView>(R.id.rv_sub_category).layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        findViewById<RecyclerView>(R.id.rv_sub_category).adapter = subCategoryAdapter
    }
}