package com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer

import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.Playable
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.SampleCoords

class V1SampleLayer private constructor(private val layerNumber: Int) : SampleLayer {
    lateinit var samplesThisLayer: Map<SampleCoords, Playable>

    override fun invokeSample(): Playable {
        val sampleCoords = LayerLogic.computeID(this)
        return samplesThisLayer[sampleCoords] ?: error("Sample not found in layer")
    }

    override fun addSample(playable: Playable) {
        TODO("Not yet implemented")
    }
    fun getLayerNumber(): Int{
        return layerNumber
    }
}