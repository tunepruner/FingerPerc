package com.tunepruner.bomboleguerodemo

import android.app.Activity
import android.content.Context
import android.media.MediaPlayer
import android.util.Log
import android.view.MotionEvent
import android.widget.LinearLayout
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

//import com.google.android.exoplayer2.ExoPlayer
//import com.google.android.exoplayer2.SimpleExoPlayer

class PlayableArea(context: Context, var listOfPlayers: List<MediaPlayer>) :
    LinearLayout(context) {
    var player1Counter = 1
    val player: Player = Player(context)

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event != null) {
            Log.i("coords", event.y.toString())
            val velocity: Int = determineVelocity(event)
            playSample(velocity)
            Log.i("velocity", velocity.toString())
            if (event.y > 1000) Log.i("zoneC", "zoneC (${event.y})")
            else if (event.y > 300 && event.y <= 1000) Log.i("zoneB", "zoneB (${event.y})")
            else Log.i("zoneA", "zoneA (${event.y})")
        }

        return super.onTouchEvent(event)
    }



    fun determineVelocity(event: MotionEvent): Int {
        var velocity: Int
        if (event.y < 1000) velocity = 9
        else velocity = 0
        return velocity
    }


}