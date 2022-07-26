package com.ravisingh.androidnotebook.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.ravisingh.androidnotebook.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler(Looper.myLooper()!!).postDelayed({
            startActivity(Intent(this, ContainerActivity::class.java))
        }, 3000)
    }
}