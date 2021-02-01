package com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer

import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.Playable
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.SampleCoords

interface SampleLayer {
    fun invokeSample(): Playable
    fun addSample(sampleCoords: SampleCoords, playable: Playable)
    fun getLayerNumber(): Int
}