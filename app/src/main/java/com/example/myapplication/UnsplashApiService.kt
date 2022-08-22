package com.example.myapplication

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UnsplashApiService {

    companion object{
        private const val BASE_URL = "https://api.unsplash.com/photos/random/"
        private var retrofit : Retrofit? = null

        fun getInstance() : Retrofit {
            if(retrofit == null){
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }
    }
}