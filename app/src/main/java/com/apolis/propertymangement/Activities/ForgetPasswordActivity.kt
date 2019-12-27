package com.apolis.propertymangement.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.apolis.propertymangement.Models.ForgetPassword
import com.apolis.propertymangement.Network.APIService
import com.apolis.propertymangement.Network.Endpoints
import com.apolis.propertymangement.R
import kotlinx.android.synthetic.main.activity_forget_password.*
import retrofit2.Call
import retrofit2.Response

class ForgetPasswordActivity : AppCompatActivity() {

    lateinit var user: ForgetPassword

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_password)

        init()
    }

    private fun init() {

        button_send_email.setOnClickListener {

            var email = edit_text_forget_email.text.toString()

            var call = APIService.APIBuild().create(Endpoints::class.java).passwordVerification(email)

            call.enqueue(object : retrofit2.Callback<ForgetPassword>{
                override fun onFailure(call: Call<ForgetPassword>, t: Throwable) {
                    Toast.makeText(applicationContext, "Email is not register", Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<ForgetPassword>, response: Response<ForgetPassword>) {

                    user = response.body()!!

                    text_view_forget_password.text = user.userpassword

                    Toast.makeText(
                        applicationContext,
                        user?.msg + "\n" + user?.useremail + "\n" + user?.userpassword,
                        Toast.LENGTH_LONG
                    ).show()

                }

            })


        }

    }
}
