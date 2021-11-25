package com.application.realtimefacedetection.proctoring

import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.provider.Settings
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

        checkDeveloperOption()
    }

    private fun checkDeveloperOption() {
        val adb: Int = Settings.Secure.getInt(
            this.contentResolver,
            Settings.Global.DEVELOPMENT_SETTINGS_ENABLED, 0
        )
        if (adb == 1) {
            Toast.makeText(this, "Developer Option is on", Toast.LENGTH_SHORT).show()
        } else {

            Toast.makeText(this, "Normie User", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onMultiWindowModeChanged(isInMultiWindowMode: Boolean, newConfig: Configuration?) {
        Toast.makeText(
            this,
            "Don't you dare try to cheat - onMultiWindowModeChanged",
            Toast.LENGTH_LONG
        ).show()
        super.onMultiWindowModeChanged(isInMultiWindowMode, newConfig)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onResume() {
        super.onResume()
        if (isInMultiWindowMode) {
            Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show()
        }
    }
}