package com.apolis.propertymangement.Activities

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.apolis.propertymangement.APIService
import com.apolis.propertymangement.Endpoints
import com.apolis.propertymangement.R
import kotlinx.android.synthetic.main.activity_register_landlord.*
import retrofit2.Call
import retrofit2.Response

class RegisterLandlordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_landlord)
        init()
    }

    private fun init() {
        button_register_landlord.setOnClickListener {
            val account_for = "landlord"
            val email = edit_text_register_landlord_email.text.toString()
            val password = edit_text_register_landlord_password.text.toString()

            val call = APIService.APIScalar().create(Endpoints::class.java)
                .createLandlord(email, password, account_for)
            call.enqueue(object : retrofit2.Callback<String> {
                override fun onFailure(call: Call<String>, t: Throwable) {
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                    Log.d("RegisterLandlord", "Failed")
                }

                override fun onResponse(call: Call<String>, response: Response<String>) {
                    Log.d("RegisterLandlord", "Success")
                    Toast.makeText(applicationContext, response.body(), Toast.LENGTH_LONG).show()
                }

            })
        }
    }
}
