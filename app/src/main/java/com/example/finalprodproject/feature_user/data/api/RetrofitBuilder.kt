package com.example.finalprodproject.feature_user.data.api

import java.util.concurrent.TimeUnit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {
    companion object {
        private var retrofit: Retrofit? = null

        fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
            val loggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            return loggingInterceptor
        }
        
        fun create(BASE_URL: String): Retrofit {
            val client: OkHttpClient.Builder = OkHttpClient.Builder().addInterceptor(getHttpLoggingInterceptor()).connectTimeout(30, TimeUnit.MINUTES)
                .readTimeout(30, TimeUnit.MINUTES)

            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(client.build())
                .build()
        }

        fun getInstance(BASE_URL: String): Retrofit {
            if (retrofit == null) retrofit = create(BASE_URL)
            
            return retrofit!!
        }   
    }
}