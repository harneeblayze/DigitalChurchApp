package com.example.digitalchurchapp.storage

import android.content.Context
import com.securepreferences.SecurePreferences

class SecurePref(context: Context) {
    var context:Context? = context
    var securePreferences: SecurePreferences? = null

    companion object{

        var AUTH_TOKEN = "com.example.digitalchurchapp.storage.AUTH_TOKEN"
        var REFRESH_TOKEN = "com.example.digitalchurchapp.storage.REFRESH_TOKEN"
        var PASSWORD = "com.example.digitalchurchapp.PASSWORD"


    }

    init {
        securePreferences = SecurePreferences(context)
    }

    fun setStringValue(key: String?, value: String?):SecurePref{
        securePreferences?.edit()?.putString(key,value)?.apply()
        return this
    }

    fun getStringValue(key: String?):String?{
        return securePreferences?.getString(key, "")
    }
}