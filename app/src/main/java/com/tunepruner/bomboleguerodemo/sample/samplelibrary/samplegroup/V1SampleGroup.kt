package com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup

import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.SampleLayer
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.Playable
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer.ZoneLayer

class V1SampleGroup: SampleGroup {
    val layers: Map<ZoneLayer, SampleLayer> = HashMap()

    override fun invokeLayer(zoneLayer: ZoneLayer): Playable {
        return layers[zoneLayer]!!.invokeSample()
    }

    override fun addLayer(sampleLayer: SampleLayer) {
        TODO("Not yet implemented")
    }
}