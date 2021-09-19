package com.example.digitalchurchapp.views.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.digitalchurchapp.R
import kotlinx.android.synthetic.main.fragment_on_boarding.*

private const val ONBOARDING_ITEM = "onboarding_item"

class OnBoardingFragment : Fragment() {
    private var onboardingItem: OnboardingItem? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            onboardingItem = it.getParcelable(ONBOARDING_ITEM)
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_on_boarding, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onboardingItem?.let { item ->

            activity?.let {
                onboarding_image.setImageResource(item.image)
                description_Text.text = item.descriptionText
            }
        }
    }


    companion object {

        @JvmStatic
        fun newInstance(item: OnboardingItem) =
            OnBoardingFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ONBOARDING_ITEM, item)
                }
            }
    }

}