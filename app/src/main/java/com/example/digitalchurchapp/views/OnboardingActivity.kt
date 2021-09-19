package com.example.digitalchurchapp.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.digitalchurchapp.R
import com.example.digitalchurchapp.databinding.ActivityOnboardingBinding
import com.example.digitalchurchapp.views.login.LoginActivity
import com.example.digitalchurchapp.views.onboarding.OnBoardingFragment
import com.example.digitalchurchapp.views.onboarding.OnboardingAdapter
import com.example.digitalchurchapp.views.onboarding.OnboardingItems
import com.example.digitalchurchapp.views.signup.SignupActivity
import kotlinx.android.synthetic.main.activity_onboarding.*

class OnboardingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewPager()

        signup.setOnClickListener { startActivity(Intent(this, SignupActivity::class.java)) }
        login.setOnClickListener { startActivity(Intent(this, LoginActivity::class.java)) }
    }


    private fun setupViewPager() {
        val fragmentList = ArrayList<Fragment>()

        for (item in OnboardingItems.getOnboardingItems()) {
            fragmentList.add(OnBoardingFragment.newInstance(item))
        }

        binding.onboardingViewpager.adapter = OnboardingAdapter(supportFragmentManager, fragmentList)

        binding.tabIndicator.setViewPager(binding.onboardingViewpager)

    }
}