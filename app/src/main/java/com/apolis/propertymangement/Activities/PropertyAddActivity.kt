package com.apolis.propertymangement.Activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.apolis.propertymangement.Models.Msg
import com.apolis.propertymangement.Network.APIService
import com.apolis.propertymangement.Network.Endpoints
import com.apolis.propertymangement.R
import kotlinx.android.synthetic.main.activity_property_add.*
import retrofit2.Call
import retrofit2.Response

class PropertyAddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_property_add)
        init()
    }

    private fun init() {
        button_add_property.setOnClickListener {
            val address = edit_text_address.text.toString()
            val city = edit_text_city.text.toString()
            val state = edit_text_state.text.toString()
            val country = edit_text_country.text.toString()
            val pro_status = edit_text_pro_status.text.toString()
            val purchase_price = edit_text_purchase_price.text.toString()
            val mortage_info = edit_text_mortgage_info.text.toString()
            val userid = "315" // Hardcoded userid just to test out functionality
            val usertype =
                "landlord" //Hardcoded usertype just to test out functionality however I think only landlord can add properties have to check this out
            val latitude = edit_text_latitude.text.toString()
            val longitude = edit_text_longitude.text.toString()
            val call = APIService.APIBuild().create(Endpoints::class.java).addProperty(
                address,
                city,
                state,
                country,
                pro_status,
                purchase_price,
                mortage_info,
                userid,
                usertype,
                latitude,
                longitude
            )
            call.enqueue(object : retrofit2.Callback<Msg> {
                override fun onFailure(call: Call<Msg>, t: Throwable) {
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<Msg>, response: Response<Msg>) {
                    val msg = response.body()!!.msg
                    Toast.makeText(applicationContext, msg[0], Toast.LENGTH_LONG).show()

                }

            })
        }
    }
}
