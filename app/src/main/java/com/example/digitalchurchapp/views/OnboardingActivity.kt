package com.example.digitalchurchapp.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.digitalchurchapp.R
import com.example.digitalchurchapp.views.login.LoginActivity
import com.example.digitalchurchapp.views.signup.SignupActivity
import kotlinx.android.synthetic.main.activity_onboarding.*

class OnboardingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)


        signup.setOnClickListener { startActivity(Intent(this, SignupActivity::class.java)) }
        login.setOnClickListener { startActivity(Intent(this, LoginActivity::class.java)) }
    }
}