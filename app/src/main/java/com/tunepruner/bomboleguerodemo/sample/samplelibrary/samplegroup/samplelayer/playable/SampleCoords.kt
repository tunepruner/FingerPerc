package com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable

interface SampleCoords {
    fun getLayerNumber(): Int
    fun getRoundRobinNumber(): Int
    fun isSame(sampleCoords: SampleCoords): Boolean
    fun getRoundRobinCount(): Int
    fun getLayerCount(): Int
}