package com.tunepruner.bomboleguerodemo.sample.samplelibrary

import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.SampleGroup
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.Playable
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer.ZoneLayer
import java.util.*

class V1SampleLibrary : SampleLibrary {
    val groups: LinkedList<SampleGroup> = LinkedList()

    override fun computeSample(zoneLayer: ZoneLayer): Playable {
        val currentGroup = groups[zoneLayer.getZoneIteration()]
        return currentGroup.invokeLayer(zoneLayer)
    }


    override fun addSampleGroup(sampleGroup: SampleGroup) {
        groups.add(sampleGroup)
    }
}