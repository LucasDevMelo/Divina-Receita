package com.example.divinareceita

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.divinareceita.entities.Category
import com.example.divinareceita.`interface`.GetDataService
import com.example.divinareceita.retofitclient.RetrofitClientInstance
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class SplashActivity : BaseActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val buttonStarted: Button = findViewById(R.id.btnGetStarted)
        buttonStarted.setOnClickListener {
            var intent = Intent(this@SplashActivity, HomeActivity:: class.java)
            startActivity(intent)
            finish()
        }
    }

    fun getCategories(){
        val service = RetrofitClientInstance.retrofitInstance.create(GetDataService::class.java)
        val call = service.getCategoryList()
        call.enqueue(object : retrofit2.Callback<List<Category>> {
            override fun onFailure(call: Call<List<Category>>, t: Throwable) {

                findViewById<ProgressBar>(R.id.loader).visibility = View.INVISIBLE
                Toast.makeText(this@SplashActivity, "Ocorreu um erro", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<List<Category>>,
                response: Response<List<Category>>
            ) {
//                insertDAtaIntoRoomDv(response.body())
            }

        })
    }

    fun insertDAtaIntoRoomDv(category: List<Category>?){

    }
}