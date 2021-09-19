package com.example.digitalchurchapp.views.onboarding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import java.util.ArrayList

class OnboardingAdapter(fm: FragmentManager, val fragmentList: ArrayList<Fragment>) :
    FragmentStatePagerAdapter(fm,
        BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
    ) {

    override fun getItem(position: Int) = fragmentList[position]

    override fun getCount() = fragmentList.size

}