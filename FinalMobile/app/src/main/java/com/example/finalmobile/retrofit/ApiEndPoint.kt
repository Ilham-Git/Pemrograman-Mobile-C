package com.example.finalmobile.retrofit

import com.example.finalmobile.MainModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndPoint {
    @GET("data.php")
    fun getData(): Call<MainModel>
}