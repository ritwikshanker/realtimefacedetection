package com.application.realtimefacedetection

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.application.realtimefacedetection.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupClickListeners()
    }

    lateinit var binding: ActivityMainBinding
    private fun setupClickListeners() {
        binding.launchCamera.setOnClickListener {
            val intent =
                Intent(applicationContext, CameraLiveActivity::class.java)
            startActivity(intent)
        }
    }
}