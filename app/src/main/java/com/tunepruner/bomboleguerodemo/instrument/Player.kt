package com.tunepruner.bomboleguerodemo.instrument

import android.graphics.Point
import android.view.MotionEvent
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.Playable

interface Player {
    fun play(x: Float, y: Float)

}