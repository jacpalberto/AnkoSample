package com.example.jacpalberto.ankosample

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.transition.TransitionManager
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.jacpalberto.ankosample.views.ConstraintAnkoActivityView
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk15.listeners.onClick

class ConstraintAnkoActivity : AppCompatActivity() {
    private var firstSetDisplayed = true
    private lateinit var constActView: View
    private lateinit var constAct: ConstraintAnkoActivityView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        constAct = ConstraintAnkoActivityView()
        constActView = constAct.setContentView(this)
        init()
    }

    private fun init() {
        constAct.upload.onClick {
            if (firstSetDisplayed) {
                firstSetDisplayed = false
                TransitionManager.beginDelayedTransition(constActView as ConstraintLayout)
                constAct.secondSet.applyTo(constActView as ConstraintLayout)
            }
        }
        constAct.discard.onClick {
            if (!firstSetDisplayed) {
                firstSetDisplayed = true
                TransitionManager.beginDelayedTransition(constActView as ConstraintLayout)
                constAct.firstSet.applyTo(constActView as ConstraintLayout)
            }
        }
    }
}