package com.apolis.propertymangement.Activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.apolis.propertymangement.R

class SplashScreenActivity : AppCompatActivity() {

    lateinit var myHandler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        myHandler = Handler()

        myHandler.postDelayed(
            {
                GoToActivity()
            }, 3000
        )

    }

    private fun GoToActivity() {

        startActivity(Intent(this, ChoiceScreenActivity::class.java))

        finish()
    }
}
