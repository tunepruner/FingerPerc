package com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable

import android.media.MediaPlayer
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.SimpleLayerLogic
import java.util.concurrent.ConcurrentLinkedQueue

class V1Sample(private val sampleCoords: SampleCoords, private val resourcePath: String) :
    Playable {
    val availPlayers = ConcurrentLinkedQueue<MediaPlayer>()
    val busyPlayers = ConcurrentLinkedQueue<MediaPlayer>()
    //Or <Exoplayer> later?

    init {
        for (i in 0..30) {
            var mediaPlayer = MediaPlayer()
            mediaPlayer.setDataSource(resourcePath)
            preparePlayers()
        }
    }

    fun preparePlayers() {
        while (availPlayers.size < 20) {
            var player = MediaPlayer()
            player.setDataSource(resourcePath)
            availPlayers.add(player)
        }
    }

    override fun play() {
        if(availPlayers.size>0){
            busyPlayers.add(availPlayers.last())
            availPlayers.remove()
            busyPlayers.last().start()
        }else{
            preparePlayers()
            play()
        }
    }

    override fun finish(playable: Playable) {
        SimpleLayerLogic.addToHistory(playable)
    }

    override fun getSampleCoords(): SampleCoords {
        return sampleCoords
    }

    private fun moveToBusy() {}
}