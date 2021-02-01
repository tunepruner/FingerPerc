package com.tunepruner.bomboleguerodemo.sample

import com.tunepruner.bomboleguerodemo.sample.samplelibrary.SampleLibrary
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.SampleLayer
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.Playable
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer.ZoneLayer

class SimpleSampleManager(val sampleLibrary: SampleLibrary): SampleManager{

    override fun computeSample(zoneLayer: ZoneLayer): Playable {
        return sampleLibrary.invokeLayer(zoneLayer)
    }

    override fun prepareSampleManager() {
        TODO("Not yet implemented")
    }


}