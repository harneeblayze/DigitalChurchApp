package com.example.digitalchurchapp.network

import android.app.Application
import com.example.digitalchurchapp.data.registerdata.RegisterRequest
import com.example.digitalchurchapp.data.registerdata.RegisterResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body


private const val BASE_URL = "https://583f64r411.execute-api.us-east-1.amazonaws.com/staging"

private val api = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()//.create(StGeraldApi::class.java)

//used when making network calls in the app using auth token and refresh token
fun getInstance(application: Application):Retrofit{
val retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(BASE_URL)
    .client(provideHttpClient(application))
        .build()

    return retrofit

}


private fun provideHttpClient(application: Application):OkHttpClient{
    val builder = OkHttpClient.Builder()
    val authenticator = TokenRefreshAuthenticator(application)

    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    builder.addInterceptor(interceptor)
    builder.authenticator(authenticator)

    return builder.build()

}


object StGeraldTokenlessService{
    val service:StGeraldApi by lazy {
        api.create(StGeraldApi::class.java)
    }

    suspend fun registerUser(request: RegisterRequest):RegisterResponse{
        return service.register(request)
    }

}


class StGeraldApiService(application: Application) {
    val retrofitService: StGeraldApi by lazy {
        getInstance(application).create(StGeraldApi::class.java)
    }



}