package com.example.jacpalberto.ankosample.extensions

import android.content.Context
import android.support.annotation.ColorRes
import android.support.v4.content.ContextCompat

/**
 * Created by Alberto Carrillo on 4/1/18.
 */
internal fun Context.getColorRes(@ColorRes color: Int): Int {
    return ContextCompat.getColor(this, color)
}