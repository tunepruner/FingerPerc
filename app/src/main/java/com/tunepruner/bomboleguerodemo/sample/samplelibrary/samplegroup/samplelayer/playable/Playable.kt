package com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable

interface Playable {
    fun createPlayer()
    fun play()
    fun getPlayable(): Playable
    fun getSampleID(): SampleID
}