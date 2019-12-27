package com.apolis.propertymangement.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.apolis.propertymangement.Models.Login
import com.apolis.propertymangement.Network.APIService
import com.apolis.propertymangement.Network.Endpoints
import com.apolis.propertymangement.R
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        init()
    }

    private fun init() {

        getLogin()
        getPassword()

    }

    private fun getPassword() {
        text_view_click_here.setOnClickListener {
            startActivity(Intent(applicationContext, ForgetPasswordActivity::class.java))
        }
    }

    private fun getLogin() {

        button_sign_in.setOnClickListener {
            val email = edit_text_login_email.text.toString()
            val password = edit_text_login_password.text.toString()

            var call = APIService.APIBuild().create(Endpoints::class.java).loginVerification(email, password)

            call.enqueue(object : retrofit2.Callback<Login>{
                override fun onFailure(call: Call<Login>, t: Throwable) {
                    Log.d("login", t.message)
                    Toast.makeText(applicationContext, "failed", Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<Login>, response: Response<Login>) {



                    var login = response.body()
                    var msg = login?.msg
                    var userid = login?.userid
                    var usertype = login?.usertype
                    var useremail = login?.useremail
                    var appapikey = login?.appapikey

                    Log.d("login", msg)

                    Toast.makeText(
                        applicationContext,
                        "msg: ${msg} " +
                                "\nuserid: $userid " +
                                "\nusertype: $usertype " +
                                "\nuseremail: $useremail " +
                                "\nappapikey: $appapikey",
                        Toast.LENGTH_LONG
                    ).show()

                    startActivity(Intent(applicationContext, MainActivity::class.java))
                }

            })



        }
    }
}
