import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.jacpalberto.ankosample.R
import com.example.jacpalberto.ankosample.RegularAnkoActivity
import org.jetbrains.anko.*

class RegularAnkoActivityView : AnkoComponent<RegularAnkoActivity> {
    override fun createView(ui: AnkoContext<RegularAnkoActivity>): View = with(ui) {
        verticalLayout {
            id = Ids.activity_main_done
            orientation = LinearLayout.VERTICAL
            weightSum = 4f

            frameLayout {
                imageView(R.drawable.singapore) {
                    id = Ids.header
                    scaleType = ImageView.ScaleType.CENTER_CROP
                }.lparams(width = wrapContent, height = matchParent)
                imageView(android.R.drawable.star_on) {
                    id = Ids.favorite
                    padding = dip(5)
                }.lparams(width = dip(36), height = dip(36))
            }.lparams(width = matchParent, height = dip(0)) {
                weight = 1F
            }
            linearLayout {
                orientation = LinearLayout.VERTICAL

                textView(R.string.singapore) {
                    id = Ids.title
                    textSize = 24f
                }.lparams(width = wrapContent, height = wrapContent) {
                    topMargin = dip(16)
                }
                linearLayout {
                    textView(R.string.camera) {
                        id = Ids.cameraLabel
                        labelFor = Ids.cameraType
                    }.lparams(width = wrapContent, height = wrapContent) {
                        gravity = Gravity.BOTTOM
                        padding = dip(8)
                    }
                    editText(R.string.camera_value) {
                        ems = 10
                        id = Ids.cameraType
                        inputType = 97
                    }.lparams(width = wrapContent, height = wrapContent) {
                        gravity = Gravity.CENTER_VERTICAL
                        topMargin = dip(8)
                    }
                }.lparams(width = matchParent, height = wrapContent)
                linearLayout {
                    textView(R.string.settings) {
                        id = Ids.settingsLabel
                        labelFor = Ids.settings
                    }.lparams(width = wrapContent, height = wrapContent) {
                        gravity = Gravity.BOTTOM
                        padding = dip(8)
                    }
                    editText(R.string.camera_settings) {
                        ems = 10
                        id = Ids.settings
                        inputType = 97
                    }.lparams(width = wrapContent, height = wrapContent) {
                        gravity = Gravity.CENTER_VERTICAL
                        topMargin = dip(8)
                    }
                }.lparams(width = matchParent, height = wrapContent)
                textView(R.string.singapore_description) {
                    id = Ids.description
                    textSize = 15f
                }.lparams(width = matchParent, height = wrapContent) {
                    topMargin = dip(8)
                    bottomMargin = dip(8)
                }
                relativeLayout {
                    button(R.string.upload) {
                        id = Ids.upload
                    }.lparams(width = wrapContent, height = wrapContent) {
                        alignParentBottom()
                        alignParentEnd()
                        bottomMargin = dip(16)
                    }
                    button(R.string.discard) {
                        elevation = 0F
                        id = Ids.discard
                    }.lparams(width = wrapContent, height = wrapContent) {
                        alignParentBottom()
                        bottomMargin = dip(16)
                    }
                }.lparams(width = matchParent, height = matchParent) {
                    gravity = Gravity.END or Gravity.BOTTOM
                }
            }.lparams(width = matchParent, height = dip(0)) {
                weight = 3F
            }
        }
    }

    private object Ids {
        const val activity_main_done = 1
        const val cameraLabel = 2
        const val cameraType = 3
        const val description = 4
        const val discard = 5
        const val favorite = 6
        const val header = 7
        const val settings = 8
        const val settingsLabel = 9
        const val title = 10
        const val upload = 11
    }
}