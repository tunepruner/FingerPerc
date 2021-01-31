package com.tunepruner.bomboleguerodemo.sample

import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.Playable
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer.ZoneLayer

interface SampleManager {
    fun computeSample(zoneLayer: ZoneLayer): Playable
    fun invokeSampleGroup(zoneLayer: ZoneLayer): Playable
    fun prepareSampleManager()
}