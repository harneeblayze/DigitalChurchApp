package com.example.digitalchurchapp.network

import android.content.Context
import com.example.digitalchurchapp.storage.SecurePref
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route


class TokenRefreshAuthenticator(var context: Context): Authenticator {
    override fun authenticate(route: Route?, response: Response): Request? {
        val refresh_token:String? = SecurePref(context).getStringValue(SecurePref.REFRESH_TOKEN)
        val token:String? = SecurePref(context).getStringValue(SecurePref.AUTH_TOKEN)

        val authorization = response.request().newBuilder().header("Authorization", token.toString())
            return authorization.build()
    }

}