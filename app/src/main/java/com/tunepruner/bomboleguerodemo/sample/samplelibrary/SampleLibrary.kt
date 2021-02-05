package com.tunepruner.bomboleguerodemo.sample.samplelibrary

import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.SampleGroup
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.Playable
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer.LayerZone

interface SampleLibrary {
    fun computeSample(layerZone: LayerZone): Playable
    fun addSampleGroup(sampleGroup: SampleGroup)
}