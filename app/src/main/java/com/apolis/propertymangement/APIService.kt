package com.apolis.propertymangement

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIService {
    companion object {
        val BASE_URL = "http://rjtmobile.com/aamir/property-mgmt/"
        fun buildAPI(): Retrofit {
            val retrofit =
                Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(
                    BASE_URL
                ).build()
            return retrofit
        }
    }

}