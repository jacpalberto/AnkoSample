package com.example.jacpalberto.ankosample.views

import android.content.Context
import android.support.constraint.ConstraintSet
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.jacpalberto.ankosample.R
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.ConstraintSetBuilder
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.constraint.layout.constraintSet

/**
 * Created by Alberto Carrillo on 5/7/18.
 */
class ConstraintAnkoActivityView : AnkoComponent<Context> {
    lateinit var firstSet: ConstraintSet
    lateinit var secondSet: ConstraintSet
    lateinit var upload: Button
    lateinit var favorite: ImageView
    lateinit var cameraType: TextView
    lateinit var settings: TextView
    lateinit var discard: Button

    override fun createView(ui: AnkoContext<Context>) = with(ui) {
        constraintLayout {
            val header = imageView(R.drawable.singapore) {
                id = View.generateViewId()
                scaleType = ImageView.ScaleType.CENTER_CROP
            }.lparams(0, 0)
            favorite = imageView(android.R.drawable.star_big_on) {
                id = View.generateViewId()
            }.lparams(dip(36), dip(36))
            val title = textView(R.string.singapore) {
                id = View.generateViewId()
                textSize = 24f
            }
            val cameraLabel = textView(R.string.camera) {
                id = View.generateViewId()
            }
            cameraType = editText(R.string.camera_value) {
                id = View.generateViewId()
                ems = 10
                labelFor = cameraLabel.id
            }
            val settingsLabel = textView(R.string.settings) {
                id = View.generateViewId()
            }
            settings = editText(R.string.camera_settings) {
                id = View.generateViewId()
                ems = 10
                labelFor = settingsLabel.id
            }
            val description = textView(R.string.singapore_description) {
                id = View.generateViewId()
                textSize = 15f
                ellipsize = TextUtils.TruncateAt.END
                isVerticalFadingEdgeEnabled = true
            }.lparams(0, 0)
            upload = button(R.string.upload) {
                id = View.generateViewId()
            }
            discard = button(R.string.discard) {
                id = View.generateViewId()
            }

            firstSet = constraintSet {
                header {
                    connect(
                            ConstraintSetBuilder.Side.TOP to ConstraintSetBuilder.Side.TOP of ConstraintSet.PARENT_ID,
                            ConstraintSetBuilder.Side.LEFT to ConstraintSetBuilder.Side.LEFT of ConstraintSet.PARENT_ID,
                            ConstraintSetBuilder.Side.RIGHT to ConstraintSetBuilder.Side.RIGHT of ConstraintSet.PARENT_ID,
                            ConstraintSetBuilder.Side.BOTTOM to ConstraintSetBuilder.Side.BOTTOM of favorite margin dip(16))
                }
                favorite {
                    connect(
                            ConstraintSetBuilder.Side.TOP to ConstraintSetBuilder.Side.TOP of ConstraintSet.PARENT_ID,
                            ConstraintSetBuilder.Side.RIGHT to ConstraintSetBuilder.Side.RIGHT of ConstraintSet.PARENT_ID margin dip(16),
                            ConstraintSetBuilder.Side.BOTTOM to ConstraintSetBuilder.Side.BOTTOM of ConstraintSet.PARENT_ID margin dip(16))
                    verticalBias = 0.25f
                }
                title {
                    connect(
                            ConstraintSetBuilder.Side.LEFT to ConstraintSetBuilder.Side.LEFT of ConstraintSet.PARENT_ID margin dip(16),
                            ConstraintSetBuilder.Side.TOP to ConstraintSetBuilder.Side.BOTTOM of header margin dip(16))
                }
                cameraLabel {
                    connect(
                            ConstraintSetBuilder.Side.LEFT to ConstraintSetBuilder.Side.LEFT of ConstraintSet.PARENT_ID margin dip(16),
                            ConstraintSetBuilder.Side.BASELINE to ConstraintSetBuilder.Side.BASELINE of cameraType)
                }
                settingsLabel {
                    connect(
                            ConstraintSetBuilder.Side.LEFT to ConstraintSetBuilder.Side.LEFT of ConstraintSet.PARENT_ID margin dip(16),
                            ConstraintSetBuilder.Side.BASELINE to ConstraintSetBuilder.Side.BASELINE of settings)
                }
                cameraType {
                    connect(
                            ConstraintSetBuilder.Side.LEFT to ConstraintSetBuilder.Side.LEFT of settings,
                            ConstraintSetBuilder.Side.TOP to ConstraintSetBuilder.Side.BOTTOM of title margin dip(8),
                            ConstraintSetBuilder.Side.RIGHT to ConstraintSetBuilder.Side.RIGHT of settings,
                            ConstraintSetBuilder.Side.START to ConstraintSetBuilder.Side.END of cameraLabel margin dip(8))
                }
                settings {
                    connect(
                            ConstraintSetBuilder.Side.TOP to ConstraintSetBuilder.Side.BOTTOM of cameraType margin dip(8),
                            ConstraintSetBuilder.Side.RIGHT to ConstraintSetBuilder.Side.RIGHT of description,
                            ConstraintSetBuilder.Side.START to ConstraintSetBuilder.Side.END of settingsLabel margin dip(8))
                }
                upload {
                    connect(
                            ConstraintSetBuilder.Side.RIGHT to ConstraintSetBuilder.Side.RIGHT of ConstraintSet.PARENT_ID margin dip(16),
                            ConstraintSetBuilder.Side.BOTTOM to ConstraintSetBuilder.Side.BOTTOM of ConstraintSet.PARENT_ID margin dip(16))
                }
                discard {
                    connect(
                            ConstraintSetBuilder.Side.RIGHT to ConstraintSetBuilder.Side.LEFT of upload margin dip(16),
                            ConstraintSetBuilder.Side.BASELINE to ConstraintSetBuilder.Side.BASELINE of upload)
                }
                description {
                    connect(
                            ConstraintSetBuilder.Side.LEFT to ConstraintSetBuilder.Side.LEFT of ConstraintSet.PARENT_ID margin dip(16),
                            ConstraintSetBuilder.Side.TOP to ConstraintSetBuilder.Side.BOTTOM of settings margin dip(8),
                            ConstraintSetBuilder.Side.RIGHT to ConstraintSetBuilder.Side.RIGHT of ConstraintSet.PARENT_ID margin dip(16),
                            ConstraintSetBuilder.Side.BOTTOM to ConstraintSetBuilder.Side.TOP of discard margin dip(8))
                }
            }

            firstSet.applyTo(this)

            secondSet = constraintSet {
                favorite {
                    connect(
                            ConstraintSetBuilder.Side.TOP to ConstraintSetBuilder.Side.TOP of ConstraintSet.PARENT_ID,
                            ConstraintSetBuilder.Side.LEFT to ConstraintSetBuilder.Side.LEFT of ConstraintSet.PARENT_ID,
                            ConstraintSetBuilder.Side.RIGHT to ConstraintSetBuilder.Side.RIGHT of ConstraintSet.PARENT_ID,
                            ConstraintSetBuilder.Side.BOTTOM to ConstraintSetBuilder.Side.BOTTOM of ConstraintSet.PARENT_ID margin dip(16))
                    verticalBias = 0.45f
                    horizontalBias = 0.1f
                }
                title {
                    connect(
                            ConstraintSetBuilder.Side.LEFT to ConstraintSetBuilder.Side.LEFT of ConstraintSet.PARENT_ID margin dip(16),
                            ConstraintSetBuilder.Side.TOP to ConstraintSetBuilder.Side.TOP of ConstraintSet.PARENT_ID margin dip(16))
                }
                cameraType {
                    connect(
                            ConstraintSetBuilder.Side.LEFT to ConstraintSetBuilder.Side.LEFT of settings,
                            ConstraintSetBuilder.Side.TOP to ConstraintSetBuilder.Side.BOTTOM of header margin dip(8),
                            ConstraintSetBuilder.Side.RIGHT to ConstraintSetBuilder.Side.RIGHT of settings,
                            ConstraintSetBuilder.Side.START to ConstraintSetBuilder.Side.END of cameraLabel margin dip(8))
                }
                discard {
                    connect(
                            ConstraintSetBuilder.Side.LEFT to ConstraintSetBuilder.Side.LEFT of ConstraintSet.PARENT_ID margin dip(16),
                            ConstraintSetBuilder.Side.BOTTOM to ConstraintSetBuilder.Side.BOTTOM of ConstraintSet.PARENT_ID margin dip(16))
                    horizontalBias = 0.1f
                }
            }
        }
    }
}