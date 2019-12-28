package com.apolis.propertymangement.Activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.apolis.propertymangement.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        button_add_property.setOnClickListener {
            startActivity(Intent(applicationContext, PropertyAddActivity::class.java))
        }
        button_list_properties.setOnClickListener {
            startActivity(Intent(applicationContext, ListPropertiesActivity::class.java))
        }
    }
}
