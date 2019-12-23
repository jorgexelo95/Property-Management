package com.apolis.propertymangement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show()
    }
}
