package com.example.myapplication

import retrofit2.Call
import retrofit2.http.GET

interface UnsplashApiInterface {
    @GET("?client_id=KumKU5nyZ_FJCaMEBktboGxBsiPnlgiHzJxveM8YSYw")
    fun getUnsplashList(): Call<UnsplashResponse>
}