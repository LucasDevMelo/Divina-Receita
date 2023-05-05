package com.example.divinareceita

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class SplashActivity : AppCompatActivity() {
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
}