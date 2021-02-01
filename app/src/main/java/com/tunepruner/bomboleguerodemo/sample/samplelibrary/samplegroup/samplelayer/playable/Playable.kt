package com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable

interface Playable {
    fun createPlayer()
    fun play()
    fun finish(playable: Playable)
    fun getSampleCoords(): SampleCoords
//    fun getSampleID(): SampleID
}