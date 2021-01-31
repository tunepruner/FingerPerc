package com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer

import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.SampleID

interface LayerLogic {
    fun computeID(): SampleID
    fun addInstance(sampleID: SampleID)
}