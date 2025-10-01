package com.example.horoscapp.data.network

import com.example.horoscapp.data.network.response.HoroscopePredictionResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface HoroscopeApiService {

    @GET("/{sign}")
    suspend fun getHoroscope(@Path("sign") sign: String): HoroscopePredictionResponse
}