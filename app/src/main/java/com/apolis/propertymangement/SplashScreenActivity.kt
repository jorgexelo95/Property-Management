package com.apolis.propertymangement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast

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
