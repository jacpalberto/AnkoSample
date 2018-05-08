package com.example.jacpalberto.ankosample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import com.example.jacpalberto.ankosample.adapters.TravelListAdapter
import com.example.jacpalberto.ankosample.model.Place
import com.example.jacpalberto.ankosample.views.RecyclerActivityView
import org.jetbrains.anko.*

class RecyclerActivity : AppCompatActivity() {
    private lateinit var menu: Menu
    private lateinit var placesRecyclerView: RecyclerView
    private lateinit var staggeredLayoutManager: StaggeredGridLayoutManager
    private var isListView: Boolean = true
    val view = RecyclerActivityView()
    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view.setContentView(this)
        toolbar = view.toolbar
        placesRecyclerView = view.recyclerView
        init()
    }

    private fun init() {
        initToolbar()
        initRvList()
    }

    private fun initToolbar() {
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.title = getString(R.string.toolbar_recycler_title)
        actionBar?.elevation = 7.0f
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initRvList() {
        placesRecyclerView.adapter = TravelListAdapter(getTravelList()) { place ->
            alert {
                title = "Hi, Its Albert again"
                positiveButton("Cool") { toast("Yay :D") }
                customView {
                    verticalLayout {
                        textView("Follow me for posts on traveling to ${place.name}")
                        imageView(place.resourceId) {
                        }.lparams(width = wrapContent, height = dip(250))
                        padding = dip(16)
                    }
                }
            }.show()
        }
        staggeredLayoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        placesRecyclerView.layoutManager = staggeredLayoutManager
    }

    private fun getTravelList() = mutableListOf(
            Place("Belgium", R.drawable.item_belgium),
            Place("Budapest", R.drawable.item_budapest),
            Place("Croatia", R.drawable.item_croatia),
            Place("Frankfurt", R.drawable.item_frankfurt),
            Place("Honk Kong", R.drawable.item_honk_kong),
            Place("London", R.drawable.item_london),
            Place("New York", R.drawable.item_new_york),
            Place("Paris", R.drawable.item_paris),
            Place("Rio de Janeiro", R.drawable.item_rio_de_janeiro),
            Place("Rome", R.drawable.item_rome),
            Place("Santorini", R.drawable.item_santorini),
            Place("Sidney", R.drawable.item_sydney),
            Place("Tokyo", R.drawable.item_tokyo),
            Place("Toronto", R.drawable.item_toronto),
            Place("Turkey", R.drawable.item_turkey),
            Place("Venice", R.drawable.item_venice))

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.recycler_menu, menu)
        this.menu = menu
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_toggle) {
            toggle()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun toggle() {
        if (isListView) showGridView()
        else showListView()
    }


    private fun showListView() {
        staggeredLayoutManager.spanCount = 1
        val item = menu.findItem(R.id.action_toggle)
        item.setIcon(R.drawable.ic_action_grid)
        item.title = getString(R.string.show_as_grid)
        isListView = true
    }

    private fun showGridView() {
        staggeredLayoutManager.spanCount = 2
        val item = menu.findItem(R.id.action_toggle)
        item.setIcon(R.drawable.ic_action_list)
        item.title = getString(R.string.show_as_list)
        isListView = false
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right)
    }
}
