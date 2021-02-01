package com.tunepruner.bomboleguerodemo.sample.samplelibrary

import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.SampleGroup
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.Playable
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer.ZoneLayer
import java.util.*

class V1SampleLibrary: SampleLibrary {
    val groups: LinkedList<SampleGroup> = LinkedList()
    fun computeSample(zoneLayer: ZoneLayer): Playable {

    }
    }
    override fun invokeLayer(): Playable {

    }

    override fun addSampleGroup(sampleGroup: SampleGroup) {
        TODO("Not yet implemented")
    }
}