package com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable

import android.media.MediaPlayer

interface Playable {
    fun play()
    fun finish(playable: Playable)
    fun getSampleCoords(): SampleCoords
//    fun getSampleID(): SampleID

}