package com.example.jacpalberto.ankosample.adapters

import android.content.Context
import android.graphics.BitmapFactory
import android.support.v4.content.ContextCompat
import android.support.v7.graphics.Palette
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.jacpalberto.ankosample.R
import com.example.jacpalberto.ankosample.model.Place
import com.example.jacpalberto.ankosample.views.PlaceItemView
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.sdk15.listeners.onClick

/**
 * Created by Alberto Carrillo on 2/13/18.
 */
class TravelListAdapter(private val places: List<Place>, private val function: (Place) -> Unit) :
        RecyclerView.Adapter<TravelListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(PlaceItemView().createView(AnkoContext.create(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(places[position], function)
    }

    override fun getItemCount() = places.size

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        private val placeTitle: TextView = itemView?.findViewById(R.id.placeText) as TextView
        val placeImage: ImageView = itemView?.findViewById(R.id.placeImage) as ImageView
        val placeholder: LinearLayout = itemView?.findViewById(R.id.placeholder) as LinearLayout
        val placeNameHolder: LinearLayout = itemView?.findViewById(R.id.placeNameHolder) as LinearLayout

        fun bind(place: Place, function: (Place) -> Unit) = with(itemView) {
            placeTitle.text = place.name
            loadImage(context, place.resourceId, placeImage)
            setPaletteColors(context, place.resourceId, placeNameHolder)
            placeholder.onClick { function(place) }
        }

        private fun setPaletteColors(context: Context, res: Int, placeNameHolder: LinearLayout) {
            val photo = BitmapFactory.decodeResource(context.resources, res)
            Palette.from(photo).generate { palette ->
                val bgColor = palette.getMutedColor(ContextCompat.getColor(context, android.R.color.black))
                placeNameHolder.setBackgroundColor(bgColor)
            }
        }

        private fun loadImage(context: Context, res: Int, placeImage: ImageView) {
            Glide.with(context)
                    .load(res)
                    .override(500, 300)
                    .fitCenter()
                    .into(placeImage)
        }
    }
}