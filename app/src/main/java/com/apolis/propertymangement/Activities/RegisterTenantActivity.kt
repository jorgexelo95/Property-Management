package com.apolis.propertymangement.Activities

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.apolis.propertymangement.Network.APIService
import com.apolis.propertymangement.Network.Endpoints
import com.apolis.propertymangement.R
import kotlinx.android.synthetic.main.activity_register_tenant.*
import retrofit2.Call
import retrofit2.Response

class RegisterTenantActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_tenant)
        init()
    }

    private fun init() {
        button_register_tenant.setOnClickListener {
            val account_for = "tenant"
            val email = edit_text_register_tenant_email.text.toString()
            val landlord_email = edit_text_register_landlord_email.text.toString()
            val password = edit_text_register_tenant_password.text.toString()
            val call = APIService.APIScalar().create(Endpoints::class.java)
                .createTenant(email, landlord_email, password, account_for)
            call.enqueue(object : retrofit2.Callback<String> {
                override fun onFailure(call: Call<String>, t: Throwable) {
                    Log.d("RegisterTenant", t.message)
                }

                override fun onResponse(call: Call<String>, response: Response<String>) {
                    Toast.makeText(applicationContext, response.body(), Toast.LENGTH_SHORT).show()
                }

            })
        }
    }
}
