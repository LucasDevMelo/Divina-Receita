package com.example.divinareceita

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.divinareceita.adapter.MainCategoryAdapter
import com.example.divinareceita.adapter.SubCategoryAdapter
import com.example.divinareceita.database.RecipeDatabase
import com.example.divinareceita.entities.CategoryItems
import com.example.divinareceita.entities.Recipes
import kotlinx.coroutines.launch

class HomeActivity : BaseActivity() {
    var arrMainCategory = ArrayList<CategoryItems>()
    var arrSubCategory = ArrayList<Recipes>()
    var mainCategoryAdapter = MainCategoryAdapter()
    var subCategoryAdapter = SubCategoryAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        getDataFromDb()
        arrSubCategory.add(Recipes(1, "Beef and mustard pie"))
        arrSubCategory.add(Recipes(2, "Chicken and mushroom hotpot"))
        arrSubCategory.add(Recipes(3, "Dessert pancakes"))
        arrSubCategory.add(Recipes(4, "kapsalon"))

        subCategoryAdapter.setData((arrSubCategory))


        findViewById<RecyclerView>(R.id.rv_sub_category).layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        findViewById<RecyclerView>(R.id.rv_sub_category).adapter = subCategoryAdapter
    }

    private fun getDataFromDb(){
        launch {
            this.let {
                val cat = RecipeDatabase.getDatabase(this@HomeActivity).recipeDao().getAllCategory()
                arrMainCategory = cat as ArrayList<CategoryItems>
                arrMainCategory.reverse()
                mainCategoryAdapter.setData(arrMainCategory)
                findViewById<RecyclerView>(R.id.rv_main_category).layoutManager = LinearLayoutManager(this@HomeActivity, LinearLayoutManager.HORIZONTAL,false)
                findViewById<RecyclerView>(R.id.rv_main_category).adapter = mainCategoryAdapter

            }


        }
    }

}