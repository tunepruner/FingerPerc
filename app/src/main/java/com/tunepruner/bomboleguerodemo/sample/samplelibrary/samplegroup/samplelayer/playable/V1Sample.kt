package com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable

import android.media.MediaPlayer
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.LayerLogic
import java.util.concurrent.ConcurrentLinkedQueue

class V1Sample(private val sampleCoords: SampleCoords, private val resourcePath: String) : Playable {
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

    override fun finish(playable: Playable) {
        LayerLogic.addInstance(playable)
    }

    override fun getSampleCoords(): SampleCoords {
        return sampleCoords
    }

    private fun moveToBusy(){}
}