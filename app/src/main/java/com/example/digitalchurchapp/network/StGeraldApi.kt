package com.example.digitalchurchapp.network

import com.example.digitalchurchapp.data.registerdata.RegisterRequest
import com.example.digitalchurchapp.data.registerdata.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface StGeraldApi {

    @POST("/register")
    suspend fun register(@Body request: RegisterRequest): RegisterResponse

}