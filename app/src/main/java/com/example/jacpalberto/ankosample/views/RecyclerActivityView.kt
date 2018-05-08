package com.example.jacpalberto.ankosample.views

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import com.example.jacpalberto.ankosample.R
import com.example.jacpalberto.ankosample.RecyclerActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.recyclerview.v7.recyclerView


/**
 * Created by Alberto Carrillo on 5/8/18.
 */
class RecyclerActivityView : AnkoComponent<RecyclerActivity> {
    lateinit var toolbar: Toolbar
    lateinit var recyclerView: RecyclerView
    override fun createView(ui: AnkoContext<RecyclerActivity>): View = with(ui) {
        verticalLayout {
            toolbar = toolbar {
                id = View.generateViewId()
                setBackgroundResource(R.color.light_blue)
            }.lparams(width = matchParent, height = dip(56))
            recyclerView = recyclerView {
                layoutManager = GridLayoutManager(context, 2)
                clipToPadding = false
                padding = dip(4)
            }.lparams(width = matchParent, height = matchParent)
        }
    }
}