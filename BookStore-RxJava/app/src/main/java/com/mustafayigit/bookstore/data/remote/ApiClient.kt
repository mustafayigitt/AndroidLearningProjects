package com.mustafayigit.bookstore.data.remote

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created By MUSTAFA
 * on 19/05/2020
 */

class ApiClient {
    companion object {
        private const val BASE_URL: String = "https://5ec40af0628c160016e70c47.mockapi.io/"
        fun getClient(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        }
    }
}
