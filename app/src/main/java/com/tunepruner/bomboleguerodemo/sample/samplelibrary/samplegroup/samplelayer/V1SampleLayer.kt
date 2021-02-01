package com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer

import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.Playable
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.SampleCoords

class V1SampleLayer (private val layerNumber: Int) : SampleLayer {
    private val samplesThisLayer: HashMap<SampleCoords, Playable> = HashMap<SampleCoords, Playable>()

    override fun invokeSample(): Playable {
        val sampleCoords = LayerLogic.computeID(this)
        return samplesThisLayer[sampleCoords] ?: error("Sample not found in layer")
    }

    override fun addSample(sampleCoords: SampleCoords, playable: Playable) {
        samplesThisLayer[sampleCoords] = playable
    }
    override fun getLayerNumber(): Int{
        return layerNumber
    }
}