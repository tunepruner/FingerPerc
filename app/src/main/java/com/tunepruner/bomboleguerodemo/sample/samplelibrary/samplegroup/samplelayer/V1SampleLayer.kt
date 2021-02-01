package com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer

import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.Playable
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.SampleCoords
import java.lang.NullPointerException

class V1SampleLayer(private val layerNumber: Int, private val layerLogic: LayerLogic) :
    SampleLayer {
    private val playablesBySampleCoords: HashMap<SampleCoords, Playable> = HashMap()
    private val sampleCoordsByInt: HashMap<Int, SampleCoords> = HashMap()
//    TODO populate this in the factory


    override fun invokeSample(): Playable {
        val sampleCoords = layerLogic.computeID(this)
        return playablesBySampleCoords[sampleCoords] ?: error("Sample not found in layer")
    }

    override fun addPlayable(sampleCoords: SampleCoords, playable: Playable) {
        playablesBySampleCoords[sampleCoords] = playable
    }

    override fun addSampleCoords(int: Int, sampleCoords: SampleCoords) {
        sampleCoordsByInt[int] = sampleCoords
    }

    override fun getLayerNumber(): Int {
        return layerNumber
    }

    override fun getSampleIDByInt(key: Int): SampleCoords {
        return sampleCoordsByInt[key] ?:
        return sampleCoordsByInt[1] ?:
        error("SampleCoords not found")
    }
}