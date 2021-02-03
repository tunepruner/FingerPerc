package com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable

import android.content.res.AssetFileDescriptor
import android.media.MediaPlayer
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.LayerLogic
import java.util.concurrent.ConcurrentLinkedQueue


class V1Sample(
    private val sampleCoords: SampleCoords,
    private val assetFileDescriptor: AssetFileDescriptor,
    private val layerLogic: LayerLogic
) :
    Playable {
    val availPlayers = ConcurrentLinkedQueue<MediaPlayer>()
    val busyPlayers = ConcurrentLinkedQueue<MediaPlayer>()

    //Or <Exoplayer> later?

    init {
            while (availPlayers.size < 3) {
                createAnotherPlayer()
            }
    }

    private fun createAnotherPlayer(){
        var mediaPlayer = MediaPlayer()
        mediaPlayer.setDataSource(assetFileDescriptor.fileDescriptor, assetFileDescriptor.startOffset, assetFileDescriptor.length);
        availPlayers.add(mediaPlayer)
        mediaPlayer.prepare()
    }




    override fun play() {
        if(availPlayers.size>0){
            var player = availPlayers.last()
            availPlayers.remove(player)
            busyPlayers.add(player)

            player.setOnCompletionListener {
                busyPlayers.remove(it)
                availPlayers.add(it)
            }
            player.start()
        }else{
            createAnotherPlayer()
            play()
        }
    }


    override fun getSampleCoords(): SampleCoords {
        return sampleCoords
    }

    private fun moveToBusy() {}
}