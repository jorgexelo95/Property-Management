package com.apolis.propertymangement.Activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.apolis.propertymangement.ListPropertyAdapter
import com.apolis.propertymangement.Models.ListProperty
import com.apolis.propertymangement.Network.APIService
import com.apolis.propertymangement.Network.Endpoints
import com.apolis.propertymangement.R
import kotlinx.android.synthetic.main.activity_list_properties.*
import retrofit2.Call
import retrofit2.Response

class ListPropertiesActivity : AppCompatActivity() {

    lateinit var listPropertyAdapter: ListPropertyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_properties)
        init()
    }

    private fun init() {
        val userid =
            "315" // This ID is unique to user jaythelandlord@apolis.com with password - 123456
        val usertype = "landlord" // need to figure out if this will always be the case
        val call =
            APIService.APIBuild().create(Endpoints::class.java).getProperties(userid, usertype)
        call.enqueue(object : retrofit2.Callback<ListProperty> {
            override fun onFailure(call: Call<ListProperty>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<ListProperty>, response: Response<ListProperty>) {
                var list = response.body()!!.list
                recycler_view_property_list.layoutManager = LinearLayoutManager(applicationContext)
                listPropertyAdapter = ListPropertyAdapter(applicationContext, list)
                recycler_view_property_list.adapter = listPropertyAdapter
            }

        })
    }
}
