package com.application.realtimefacedetection.proctoring

import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.application.realtimefacedetection.R
import com.application.realtimefacedetection.databinding.ActivityProctoringBinding

class ProctoringActivity : AppCompatActivity() {
    lateinit var binding: ActivityProctoringBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_proctoring)
    }

    override fun onMultiWindowModeChanged(isInMultiWindowMode: Boolean, newConfig: Configuration?) {
        Toast.makeText(this, "Don't you dare try to cheat - onMultiWindowModeChanged", Toast.LENGTH_LONG).show()
        super.onMultiWindowModeChanged(isInMultiWindowMode, newConfig)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onResume() {
        super.onResume()
        if (isInMultiWindowMode){
            Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show()
        }
    }
}