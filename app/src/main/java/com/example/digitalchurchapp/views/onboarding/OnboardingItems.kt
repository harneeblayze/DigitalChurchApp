package com.example.digitalchurchapp.views.onboarding

import android.os.Parcelable
import com.example.digitalchurchapp.R
import kotlinx.android.parcel.Parcelize

class OnboardingItems {
    companion object {
        var onboardingItem1 = OnboardingItem(
            R.drawable.ic_jesus,

            //Casting all your anxieties on him, because he cares for you.

            "Casting all your anxieties on him, \n" +
                    "because he cares for you"
        )
        var onboardingItem2 = OnboardingItem(
            R.drawable.ic_mary2,

            "Give thanks to the LORD for He is good: \n" +
                    "His love endures forever"
        )
        var onboardingItem3 = OnboardingItem(
            R.drawable.ic_little_angel_and_bible,

            "Taste and see that the LORD is good; \n" +
                    "blessed is the one who takes refuge in him."
        )


        var onboardingItem4 = OnboardingItem(
            R.drawable.ic_praying_hands,

            "Prayer does not change the purpose of God\n" +
                    "but does changes the heart of God"
        )

        var onboardingItem5 = OnboardingItem(
            R.drawable.ic_prayinggirl,

            "Be strong, and let your heart take courage,\n" +
                    "all you who wait for the LORD!"
        )




        var items: Array<OnboardingItem> =
            arrayOf(onboardingItem1, onboardingItem2, onboardingItem5, onboardingItem3, onboardingItem4)


        fun getOnboardingItems() = items
    }
}


@Parcelize
data class OnboardingItem(var image:Int, var descriptionText:String):
    Parcelable
