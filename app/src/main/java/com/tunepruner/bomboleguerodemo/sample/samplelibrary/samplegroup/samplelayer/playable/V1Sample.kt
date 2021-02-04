package com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable

import android.content.res.AssetFileDescriptor
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.media.SoundPool
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import java.util.concurrent.ConcurrentLinkedQueue


class V1Sample(
    private val sampleCoords: SampleCoords,
    private val assetFileDescriptor: AssetFileDescriptor,
) :
    Playable {
    val audioAttributes = AudioAttributes.Builder()
        .setUsage(
            AudioAttributes.USAGE_ASSISTANCE_SONIFICATION
        )
        .setContentType(
            AudioAttributes.CONTENT_TYPE_SONIFICATION
        )
        .build()
    val soundPool = SoundPool.Builder()
        .setMaxStreams(3)
        .setAudioAttributes(
            audioAttributes
        )
        .build()
    var soundID = soundPool.load(assetFileDescriptor, 1)

    override fun play() {
        soundPool.play(soundID, 1F, 1F, 1, 0, 1F)
    }


    override fun getSampleCoords(): SampleCoords {
        return sampleCoords
    }
}