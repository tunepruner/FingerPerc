package com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup

import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.SampleLayer
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.Playable
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer.ZoneLayer

class V1SampleGroup: SampleGroup {
    private val layers: HashMap<ZoneLayer, SampleLayer> = HashMap()

    override fun invokeLayer(zoneLayer: ZoneLayer): Playable {
        return layers[zoneLayer]?.invokeSample() ?: error("Sample group looked for a match layer in it's list, but couldn't find one.")
    }

    override fun addLayer(zoneLayer: ZoneLayer, sampleLayer: SampleLayer) {
        layers[zoneLayer] = sampleLayer
    }
}