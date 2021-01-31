package com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer

import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.Playable
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.SampleID

class V1SampleLayer: SampleLayer {

    lateinit var samplesThisLayer: Map<SampleID, Playable>

    override fun invokeSample(): Playable {
        TODO("Not yet implemented")
    }

    override fun addSample(playable: Playable) {
        TODO("Not yet implemented")
    }
}