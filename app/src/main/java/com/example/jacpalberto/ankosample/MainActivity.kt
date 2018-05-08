package com.example.jacpalberto.ankosample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.jacpalberto.ankosample.views.MainActivityView
import org.jetbrains.anko.sdk15.listeners.onClick
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {
    val view = MainActivityView()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view.setContentView(this)
        init()
    }

    private fun init() {
        view.regularButton.onClick { startActivity<RegularActivity>() }
        view.regularAnkoButton.onClick { startActivity<RegularAnkoActivity>() }
        view.constraintButton.onClick { startActivity<ConstraintActivity>() }
        view.constraintAnkoButton.onClick { startActivity<ConstraintAnkoActivity>() }
        view.recyclerButton.onClick { startActivity<RecyclerActivity>() }
        view.practiceButton.onClick {  }
    }
}