package com.tunepruner.bomboleguerodemo

import android.app.Activity
import android.graphics.Point
import android.view.MotionEvent
import android.widget.LinearLayout
import com.tunepruner.bomboleguerodemo.instrument.Instrument

class PlayableArea(activity: Activity) :
    LinearLayout(activity) {
    var instrument: Instrument = instrumentFactory(activity)


    override fun onTouchEvent(event: MotionEvent): Boolean {
        val point = Point()
        point.x = event.x.toInt()
        point.y = event.y.toInt()
        instrument.onTouch(event)
        return true
    }
}

fun instrumentFactory(activity: Activity): Instrument {
    return Instrument(activity)
}