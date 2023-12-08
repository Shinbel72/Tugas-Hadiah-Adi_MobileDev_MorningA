package com.example.adi_mobiledev_morning_a

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET ("character")
    fun getAdi():Call<ResponseAdi>
}