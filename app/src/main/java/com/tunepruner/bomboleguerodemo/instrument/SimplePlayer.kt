package com.tunepruner.bomboleguerodemo.instrument

import android.graphics.Point
import android.media.MediaPlayer
import com.tunepruner.bomboleguerodemo.sample.SampleManager
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.Playable
import com.tunepruner.bomboleguerodemo.trigger.TriggerManager
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

class SimplePlayer(val triggerManager: TriggerManager, val sampleManager: SampleManager): Player{
    override fun play(point: Point){
        val zoneLayer = triggerManager.computeZoneLayer(point)
        val playable = sampleManager.computeSample(zoneLayer!!)
            playOnNewThread(playable)

    }
    private fun playOnNewThread(playable: Playable) = runBlocking {
        val thread = async {
            playable.play()
        }
        thread.await()
    }
}