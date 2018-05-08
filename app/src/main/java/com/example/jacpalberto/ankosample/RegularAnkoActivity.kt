package com.example.jacpalberto.ankosample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.jacpalberto.ankosample.views.ConstraintAnkoActivityView
import org.jetbrains.anko.setContentView

class RegularAnkoActivity : AppCompatActivity() {
    private lateinit var regularActivityView: ConstraintAnkoActivityView
    private lateinit var view: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        regularActivityView = ConstraintAnkoActivityView()
        view = regularActivityView.setContentView(this)
        init()
    }

    private fun init() {
    }
}
