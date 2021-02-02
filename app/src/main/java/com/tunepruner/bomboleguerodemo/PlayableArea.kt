package com.tunepruner.bomboleguerodemo

import android.app.Activity
import android.content.Context
import android.media.MediaPlayer
import android.util.Log
import android.view.MotionEvent
import android.widget.LinearLayout
import com.tunepruner.bomboleguerodemo.instrument.Instrument
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

//import com.google.android.exoplayer2.ExoPlayer
//import com.google.android.exoplayer2.SimpleExoPlayer

class PlayableArea(activity: Activity, var listOfPlayers: List<MediaPlayer>) :
    LinearLayout(activity) {



    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event != null) {
            Log.i("coords", event.y.toString())

        }

        return super.onTouchEvent(event)
    }

}

fun instrumentFactory(activity: Activity): Instrument {

    return Instrument(activity)
}