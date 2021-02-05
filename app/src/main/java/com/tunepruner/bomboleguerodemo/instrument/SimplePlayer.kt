package com.tunepruner.bomboleguerodemo.instrument

import android.view.MotionEvent
import com.tunepruner.bomboleguerodemo.sample.SampleManager
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.Playable
import com.tunepruner.bomboleguerodemo.trigger.TriggerManager
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

class SimplePlayer(
    private val touchLogic: TouchLogic,
    private val triggerManager: TriggerManager,
    private val sampleManager: SampleManager
) : Player {

    override fun play(event: MotionEvent) {
        val pointF = touchLogic.reduceTouchEvent(event)
        if (pointF != null) {
            val zoneLayer = triggerManager.computeZoneLayer(pointF)
            val playable = sampleManager.computeSample(zoneLayer)
            playable.play()
        }
    }
}

