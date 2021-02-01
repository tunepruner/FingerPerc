package com.tunepruner.bomboleguerodemo.instrument

import android.graphics.Point
import com.tunepruner.bomboleguerodemo.sample.SampleLibraryFactory
import com.tunepruner.bomboleguerodemo.sample.SampleManager
import com.tunepruner.bomboleguerodemo.sample.SimpleSampleManager
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.SampleLibrary
import com.tunepruner.bomboleguerodemo.trigger.SimpleTriggerManager
import com.tunepruner.bomboleguerodemo.trigger.TriggerGraphFactory
import com.tunepruner.bomboleguerodemo.trigger.TriggerManager
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.TriggerGraph

class Instrument{
    lateinit var player: Player

    init {
        ResourceManager.prepareSnapshot()
        val triggerGraph: TriggerGraph = TriggerGraphFactory.prepareTriggers()
        val sampleLibrary: SampleLibrary = SampleLibraryFactory.prepareSamples(triggerGraph)

        val sampleManager: SampleManager =  SimpleSampleManager(sampleLibrary)
        val triggerManager: TriggerManager = SimpleTriggerManager(triggerGraph)

        player = PlayerFactory.getInstance(triggerManager, sampleManager)
    }

    fun onTouch(point: Point){
        player.play(point)
    }
}