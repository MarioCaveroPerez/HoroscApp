package com.example.horoscapp.domain

import com.example.horoscapp.data.network.response.HoroscopePredictionResponse
import com.example.horoscapp.domain.model.PredictionModel

interface Repository {
    suspend fun getPrediction(sign: String): PredictionModel?
}