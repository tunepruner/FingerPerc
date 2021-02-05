package com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup

import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.SampleLayer
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.Playable
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer.LayerZone

interface SampleGroup {
    fun invokeLayer(layerZone: LayerZone): Playable
    fun addLayer(layerZone: LayerZone, sampleLayer: SampleLayer)
}