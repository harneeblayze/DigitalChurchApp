package com.example.digitalchurchapp.views.signup

import android.animation.Animator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.widget.NestedScrollView
import com.example.digitalchurchapp.R
import com.example.digitalchurchapp.views.OnboardingActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : AppCompatActivity() {
    private lateinit var bottomSheetBehavoir: BottomSheetBehavior<NestedScrollView>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)


        spinnball.addAnimatorListener(object: Animator.AnimatorListener{
            override fun onAnimationStart(p0: Animator?) {

            }

            override fun onAnimationEnd(p0: Animator?) {
               openBottomSheet()
            }

            override fun onAnimationCancel(p0: Animator?) {

            }

            override fun onAnimationRepeat(p0: Animator?) {

            }
        })

        handleBottomSheet()
        setBottomSheetCallBack()


    }

    private fun handleBottomSheet() {
        bottomSheetBehavoir = BottomSheetBehavior.from(bottom_sheet)
        bottomSheetBehavoir.state = BottomSheetBehavior.STATE_HIDDEN
        signup_bg.setOnClickListener {
            closeBottomSheet()
        }
    }

    private fun setBottomSheetCallBack() {
        bottomSheetBehavoir.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(view: View, state: Int) {
                val v: View = findViewById(R.id.signup_bg)
                when (state) {
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        v.visibility = View.VISIBLE
                    }
                    BottomSheetBehavior.STATE_HALF_EXPANDED -> {
                        v.visibility = View.VISIBLE
                    }
                    BottomSheetBehavior.STATE_EXPANDED -> {
                        v.visibility = View.VISIBLE
                    }
                    BottomSheetBehavior.STATE_SETTLING -> {
                    }
                    BottomSheetBehavior.STATE_DRAGGING -> {
                    }
                    BottomSheetBehavior.STATE_HIDDEN -> {
                        v.visibility = View.GONE
                        finish()
                    }
                }
            }

            override fun onSlide(view: View, v: Float) {
                val vi: View = findViewById(R.id.signup_bg)
                vi.visibility = View.VISIBLE
            }
        })
    }

    private fun openBottomSheet() {
        bottomSheetBehavoir.state = BottomSheetBehavior.STATE_COLLAPSED
    }

    private fun closeBottomSheet() {
        bottomSheetBehavoir.state = BottomSheetBehavior.STATE_HIDDEN
    }

    override fun onBackPressed() {
        if (bottomSheetBehavoir.state == BottomSheetBehavior.STATE_HIDDEN) {
            super.onBackPressed()
        } else {
            bottomSheetBehavoir.setState(BottomSheetBehavior.STATE_HIDDEN)
        }
    }

}