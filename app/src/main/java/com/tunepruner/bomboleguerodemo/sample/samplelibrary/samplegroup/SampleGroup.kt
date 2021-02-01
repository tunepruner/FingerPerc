package com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup

import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.SampleLayer
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.Playable
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer.ZoneLayer

interface SampleGroup {
    fun invokeLayer(zoneLayer: ZoneLayer): Playable
    fun addLayer(sampleLayer: SampleLayer)
}