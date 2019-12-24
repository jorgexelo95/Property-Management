package com.apolis.propertymangement

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Endpoints {
    @GET("pro_mgt_login.php")
    fun createTenant(
        @Query("email") email: String, @Query("landlord_email") landlord_email: String, @Query(
            "password"
        ) password: String, @Query("account_for") account_for: String
    ): Call<List<String>>

    @GET("pro_mgt_login.php")
    fun createLandlord(
        @Query("email") email: String, @Query(
            "password"
        ) password: String, @Query("account_for") account_for: String
    ): Call<List<String>>

}