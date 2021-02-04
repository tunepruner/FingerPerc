package com.tunepruner.bomboleguerodemo

import android.app.Activity
import android.content.Context
import android.graphics.Point
import android.media.MediaPlayer
import android.util.Log
import android.view.MotionEvent
import android.widget.LinearLayout
import com.tunepruner.bomboleguerodemo.instrument.Instrument
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

//import com.google.android.exoplayer2.ExoPlayer
//import com.google.android.exoplayer2.SimpleExoPlayer

class PlayableArea(activity: Activity) :
    LinearLayout(activity) {
    lateinit var instrument: Instrument

    init {
        instrument = instrumentFactory(activity)
    }


//    fun onTouchEvent(x: Float, y: Float) {
//    }

    override fun performClick(): Boolean {
        return super.performClick()

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val point = Point()
        point.x = event.x.toInt()
        point.y = event.y.toInt()
        instrument.onTouch(event)
        return true
    }
//
}

fun instrumentFactory(activity: Activity): Instrument {
    return Instrument(activity)
}