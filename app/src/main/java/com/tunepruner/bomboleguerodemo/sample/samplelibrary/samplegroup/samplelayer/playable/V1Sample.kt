package com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable

import android.media.MediaPlayer
import android.util.Log
import com.tunepruner.bomboleguerodemo.instrument.ResourceManager
import java.util.concurrent.ConcurrentLinkedQueue

class V1Sample(val sampleID: SampleID, val resourcePath: String) : Playable {
    val availPlayers = ConcurrentLinkedQueue<MediaPlayer>()
    val busyPlayers =  ConcurrentLinkedQueue<MediaPlayer>()
    //Or <Exoplayer> later?

    init {
        for (i in 0..30) {
            var mediaPlayer = MediaPlayer()
            mediaPlayer.setDataSource(resourcePath)
            availPlayers.add(mediaPlayer)
        }
    }

    override fun createPlayer() {

    }

    override fun play() {
        createPlayer()
    }

    private fun moveToBusy(){}
}