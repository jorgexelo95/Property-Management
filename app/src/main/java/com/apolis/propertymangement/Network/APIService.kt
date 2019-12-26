package com.apolis.propertymangement.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class APIService {
    companion object {
        val BASE_URL = "http://rjtmobile.com/aamir/property-mgmt/"

        fun APIScalar(): Retrofit {
            val retrofit =
                Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build()
            return retrofit
        }

        fun APIBuild(): Retrofit {
            val retrofit =
                Retrofit
                    .Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()
            return retrofit
        }
    }

}