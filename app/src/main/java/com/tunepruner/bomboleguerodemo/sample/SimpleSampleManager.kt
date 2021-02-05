package com.tunepruner.bomboleguerodemo.sample

import com.tunepruner.bomboleguerodemo.sample.samplelibrary.SampleLibrary
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.Playable
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer.LayerZone

class SimpleSampleManager(val sampleLibrary: SampleLibrary): SampleManager{

    override fun computeSample(layerZone: LayerZone): Playable {
        return sampleLibrary.computeSample(layerZone)
    }


}