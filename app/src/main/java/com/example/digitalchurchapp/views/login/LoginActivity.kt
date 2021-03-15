package com.example.digitalchurchapp.views.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.digitalchurchapp.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        logintoolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        logintoolbar.setNavigationOnClickListener { onBackPressed() }
    }
}