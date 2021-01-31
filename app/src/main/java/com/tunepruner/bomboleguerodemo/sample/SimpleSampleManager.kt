package com.tunepruner.bomboleguerodemo.sample

import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.SampleLayer
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.Playable
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer.ZoneLayer

class SimpleSampleManager: SampleManager{
    lateinit var layers: Map<ZoneLayer, SampleLayer>
    override fun computeSample(zoneLayer: ZoneLayer): Playable {
        TODO("Not yet implemented")
    }

    override fun invokeSampleGroup(zoneLayer: ZoneLayer): Playable {
        TODO("Not yet implemented")
    }

    override fun prepareSampleManager() {
        TODO("Not yet implemented")
    }


}