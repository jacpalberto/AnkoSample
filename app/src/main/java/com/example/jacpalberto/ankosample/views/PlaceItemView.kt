package com.example.jacpalberto.ankosample.views

import android.content.Context
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import com.example.jacpalberto.ankosample.R
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

/**
 * Created by Alberto Carrillo on 5/8/18.
 */
class PlaceItemView : AnkoComponent<Context> {
    lateinit var placeImage: ImageView
    override fun createView(ui: AnkoContext<Context>): View = with(ui) {

        relativeLayout {
            padding = dip(4)

            cardView {
                radius = dip(4).toFloat()
                cardElevation = dip(4).toFloat()
                preventCornerOverlap = true

                placeImage = imageView {
                    id = R.id.placeImage
                    scaleType = ImageView.ScaleType.CENTER_CROP
                }.lparams(width = matchParent, height = dip(200))

                linearLayout {
                    id = R.id.placeholder
                }.lparams(width = matchParent, height = matchParent)
                linearLayout {
                    id = R.id.placeNameHolder
                    textView {
                        id = R.id.placeText
                        textColorResource = android.R.color.white
                        textSize = 17F
                        gravity = Gravity.CENTER_VERTICAL
                    }.lparams(width = matchParent, height = wrapContent) {
                        padding = dip(8)
                    }
                }.lparams(width = matchParent, height = dip(45)){
                    gravity = Gravity.BOTTOM
                }
            }.lparams(width = matchParent, height = wrapContent)
        }
    }
}