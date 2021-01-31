package com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer

import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.Playable

interface SampleLayer {
    fun invokeSample(): Playable
    fun addSample(playable: Playable)
}