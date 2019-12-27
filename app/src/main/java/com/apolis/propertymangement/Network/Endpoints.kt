package com.apolis.propertymangement.Network

import com.apolis.propertymangement.Models.ForgetPassword
import com.apolis.propertymangement.Models.Login
import com.apolis.propertymangement.Models.Msg
import com.apolis.propertymangement.Models.PropertyArray
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
        @Query("email") email: String,
        @Query("password") password: String
    ): Call<Login>

    @GET("pro_mgt_add_pro.php?")
    fun addProperty(
        @Query("address") address: String,
        @Query("city") city: String,
        @Query("state") state: String,
        @Query("country") country: String,
        @Query("pro_status") pro_status: String,
        @Query("purchase_price") purchase_price: String,
        @Query("mortage_info") mortage_info: String,
        @Query("userid") userid: String,
        @Query("usertype") usertype: String,
        @Query("Latitude") latitude: String,
        @Query("longitude") longitude: String
    ): Call<Msg>

    @GET("property.php?")
    fun getProperties(
        @Query("userid") userid: String,
        @Query("usertype") usertype: String
    ): Call<PropertyArray>

    @GET("remove-property.php?")
    fun deleteProperty(
        @Query("propertyid") propertyid: String
    ): Call<Msg>

    @GET("pro_mgt_add_tenants.php?")
    fun addTenant(
        @Query("name") name: String,
        @Query("email") email: String,
        @Query("address") address: String,
        @Query("mobile") mobile: String,
        @Query("propertyid") propertyid: String,
        @Query("landlordid") landlordid: String
    ): Call<String>

    @GET("pro_mgt_forgot_pass.php?")
    fun passwordVerification(
        @Query("email") email: String
    ): Call<ForgetPassword>
}