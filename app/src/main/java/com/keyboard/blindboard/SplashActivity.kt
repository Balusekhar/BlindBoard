package com.keyboard.blindboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.content.ContextCompat

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        window.statusBarColor= ContextCompat.getColor(this@SplashActivity,R.color.black)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@MainActivity,SplashActivity::class.java))
       finish()
        },2000)
    }
}