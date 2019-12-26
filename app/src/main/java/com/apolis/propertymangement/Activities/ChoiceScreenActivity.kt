package com.apolis.propertymangement.Activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.apolis.propertymangement.R
import kotlinx.android.synthetic.main.activity_choice_screen.*

class ChoiceScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice_screen)
        init()
    }

    private fun init() {
        button_sign_up.setOnClickListener {
            startActivity(Intent(applicationContext, ChoiceRegistrationActivity::class.java))
        }
    }
}
