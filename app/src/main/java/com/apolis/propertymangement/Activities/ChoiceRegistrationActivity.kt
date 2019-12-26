package com.apolis.propertymangement.Activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.apolis.propertymangement.R
import kotlinx.android.synthetic.main.activity_choice_registration.*

class ChoiceRegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice_registration)
        init()

    }

    private fun init() {
        button_register_tenant.setOnClickListener {
            startActivity(Intent(applicationContext, RegisterTenantActivity::class.java))
        }
        button_register_landlord.setOnClickListener {
            startActivity(Intent(applicationContext, RegisterLandlordActivity::class.java))
        }
    }
}
