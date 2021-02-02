package com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable

import android.media.MediaPlayer
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.LayerLogic
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.SimpleLayerLogic
import java.util.concurrent.ConcurrentLinkedQueue

class V1Sample(private val sampleCoords: SampleCoords, private val resourcePath: String, private val layerLogic: LayerLogic) :
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
            var player = availPlayers.last()
            availPlayers.remove(player)
            busyPlayers.add(player)
            player.start()
            player.setOnCompletionListener {
                busyPlayers.remove(it)
                availPlayers.add(it)
            }
        }else{
            preparePlayers()
            play()
        }
    }


    override fun getSampleCoords(): SampleCoords {
        return sampleCoords
    }

    private fun moveToBusy() {}
}