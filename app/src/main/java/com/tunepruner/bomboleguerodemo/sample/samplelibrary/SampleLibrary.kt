package com.tunepruner.bomboleguerodemo.sample.samplelibrary

import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.SampleGroup
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.Playable
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer.ZoneLayer

interface SampleLibrary {
    fun computeSample(zoneLayer: ZoneLayer): Playable
    fun addSampleGroup(sampleGroup: SampleGroup)
}