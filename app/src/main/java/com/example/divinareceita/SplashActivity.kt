package com.example.divinareceita

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.divinareceita.database.RecipeDatabase
import com.example.divinareceita.entities.Category
import com.example.divinareceita.`interface`.GetDataService
import com.example.divinareceita.retofitclient.RetrofitClientInstance
import kotlinx.coroutines.launch
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class SplashActivity : BaseActivity(), EasyPermissions.RationaleCallbacks, EasyPermissions.PermissionCallbacks{
    private var READ_STORAGE_PERM = 123
    val buttonStarted: Button = findViewById(R.id.btnGetStarted)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        readStorageTask()


        buttonStarted.setOnClickListener {
            var intent = Intent(this@SplashActivity, HomeActivity:: class.java)
            startActivity(intent)
            finish()
        }
    }

    fun getCategories(){
        val service = RetrofitClientInstance.retrofitInstance!!.create(GetDataService::class.java)
        val call = service.getCategoryList()  
        call.enqueue(object : Callback<Category>{
            override fun onFailure(call: Call<Category>, t: Throwable) {

                findViewById<ProgressBar>(R.id.loader).visibility = View.INVISIBLE
                Toast.makeText(this@SplashActivity, "Ocorreu um erro", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<Category>,
                response: Response<Category>
            ) {
                insertDataIntoRoomDb(response.body())
            }

        })
    }

    fun insertDataIntoRoomDb(category: Category?){

        launch {
            this.let {
                RecipeDatabase.getDatabase(this@SplashActivity).recipeDao().clearDb()
                for (arr in category!!.categorieitems!!){
                    RecipeDatabase.getDatabase((this@SplashActivity))
                        .recipeDao().insertCategory(arr)
                }

                buttonStarted.visibility = View.VISIBLE
            }
        }

    }

    private fun hasReadStoragePermission():Boolean{
        return EasyPermissions.hasPermissions(this, android.Manifest.permission.READ_EXTERNAL_STORAGE)
    }

    private fun readStorageTask(){
        if(!hasReadStoragePermission()){
            getCategories()

        } else {
            EasyPermissions.requestPermissions(
                this,
                "Este aplicativo precisa de acessar seu armazenamento",
                READ_STORAGE_PERM,
                android.Manifest.permission.READ_EXTERNAL_STORAGE
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode,permissions,grantResults,this)
    }
    override fun onRationaleAccepted(requestCode: Int) {
        TODO("Not yet implemented")
    }

    override fun onRationaleDenied(requestCode: Int) {

    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
        TODO("Not yet implemented")
    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this,perms)){
            AppSettingsDialog.Builder(this).build().show()
        }
    }
}
