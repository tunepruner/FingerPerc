package com.tunepruner.bomboleguerodemo.sample

import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.Playable
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer.LayerZone

interface SampleManager {
    fun computeSample(layerZone: LayerZone): Playable
}