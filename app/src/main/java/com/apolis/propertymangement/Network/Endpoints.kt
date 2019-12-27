package com.apolis.propertymangement.Network

import com.apolis.propertymangement.Models.Login
import com.apolis.propertymangement.Models.ForgetPassword
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface Endpoints {
    @POST("pro_mgt_reg.php")
    fun createTenant(
        @Query("email") email: String,
        @Query("landlord_email") landlord_email: String,
        @Query("password") password: String,
        @Query("account_for") account_for: String
    ): Call<String>

    @POST("pro_mgt_reg.php?")
    fun createLandlord(
        @Query("email") email: String,
        @Query("password") password: String,
        @Query("account_for") account_for: String
    ): Call<String>

    @GET("pro_mgt_login.php?")
    fun loginVerification(
        @Query("email") email: String, @Query("password") password: String
    ): Call<Login>

    @GET("pro_mgt_forgot_pass.php?")
    fun passwordVerification(
        @Query("email") email: String
    ) : Call<ForgetPassword>
}