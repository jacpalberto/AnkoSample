package com.example.jacpalberto.ankosample.views

import android.content.res.ColorStateList
import android.support.annotation.ColorRes
import android.support.annotation.StringRes
import android.support.v4.content.ContextCompat
import android.view.Gravity
import android.widget.Button
import android.widget.ImageView
import com.example.jacpalberto.ankosample.MainActivity
import com.example.jacpalberto.ankosample.R
import com.example.jacpalberto.ankosample.extensions.getColorRes
import org.jetbrains.anko.*

/**
 * Created by Alberto Carrillo on 5/4/18.
 */
class MainActivityView : AnkoComponent<MainActivity> {
    lateinit var regularButton: Button
    lateinit var regularAnkoButton: Button
    lateinit var constraintButton: Button
    lateinit var constraintAnkoButton: Button
    lateinit var recyclerButton: Button
    lateinit var practiceButton: Button

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        verticalLayout {
            gravity = Gravity.CENTER_VERTICAL
            setBackgroundColor(ContextCompat.getColor(ctx, android.R.color.white))
            linearLayout {
                weightSum = 1F
                gravity = Gravity.CENTER_HORIZONTAL
                imageView(R.drawable.img_anko) {
                    scaleType = ImageView.ScaleType.FIT_CENTER
                }.lparams(width = 0) {
                    weight = .6F
                }
            }
            linearLayout {
                gravity = Gravity.CENTER_HORIZONTAL
                weightSum = 1F
                regularButton = createColorfulButton(ui, R.color.dark_purple, R.string.regular_activity)
            }
            linearLayout {
                gravity = Gravity.CENTER_HORIZONTAL
                weightSum = 1F
                regularAnkoButton = createColorfulButton(ui, R.color.blue, R.string.regular_anko_activity)
            }
            linearLayout {
                gravity = Gravity.CENTER_HORIZONTAL
                weightSum = 1F
                constraintButton = createColorfulButton(ui, R.color.cyan, R.string.constraint_activity)
            }
            linearLayout {
                gravity = Gravity.CENTER_HORIZONTAL
                weightSum = 1F
                constraintAnkoButton = createColorfulButton(ui, R.color.turquoise, R.string.constraint_anko_activity)
            }
            linearLayout {
                gravity = Gravity.CENTER_HORIZONTAL
                weightSum = 1F
                recyclerButton = createColorfulButton(ui, R.color.dark_green, R.string.recycler_anko_activity)
            }
            linearLayout {
                gravity = Gravity.CENTER_HORIZONTAL
                weightSum = 1F
                practiceButton = createColorfulButton(ui, R.color.darker_green, R.string.practice_anko_activity)
            }
        }
    }

    private fun @AnkoViewDslMarker _LinearLayout.createColorfulButton(
            ui: AnkoContext<MainActivity>, @ColorRes colorRes: Int, @StringRes stringRes: Int) =
            button(stringRes) {
                backgroundTintList = ColorStateList.valueOf(ui.ctx.getColorRes(colorRes))
                textColorResource = android.R.color.white
            }.lparams {
                weight = .9F
                topMargin = 10
            }
}
