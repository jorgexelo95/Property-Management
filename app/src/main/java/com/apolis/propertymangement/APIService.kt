package com.apolis.propertymangement

import retrofit2.Retrofit
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
    }

}