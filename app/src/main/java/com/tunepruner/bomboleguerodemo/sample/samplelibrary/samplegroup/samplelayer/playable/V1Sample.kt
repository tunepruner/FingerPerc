package com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable

import android.content.res.AssetFileDescriptor
import android.media.MediaPlayer
import android.util.Log
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.RoundRobinLogic
import java.util.concurrent.ConcurrentLinkedQueue


class V1Sample(
    private val sampleCoords: SampleCoords,
    private val assetFileDescriptor: AssetFileDescriptor,
) :
    Playable {
    private val availPlayers = ConcurrentLinkedQueue<MediaPlayer>()
    private val busyPlayers = ConcurrentLinkedQueue<MediaPlayer>()

    //Or <Exoplayer> later?

    init {
        while (availPlayers.size < 1) {
            createAnotherPlayer()
        }
        Log.i("sizeOfAvail", "${availPlayers.size}")
    }

    private fun createAnotherPlayer() {
        var mediaPlayer = MediaPlayer()
        mediaPlayer.setDataSource(
            assetFileDescriptor.fileDescriptor,
            assetFileDescriptor.startOffset,
            assetFileDescriptor.length
        );
        mediaPlayer.prepare()
        availPlayers.add(mediaPlayer)

    }


    override fun play() {
        var player = availPlayers.last()
        player.setOnCompletionListener {
            busyPlayers.remove(it)
            availPlayers.add(it)
        }


        if (availPlayers.size > 0) {
            availPlayers.remove(player)
            busyPlayers.add(player)
            player.start()
        } else {
            createAnotherPlayer()
            play()
        }
    }


    override fun getSampleCoords(): SampleCoords {
        return sampleCoords
    }

    private fun moveToBusy() {}
}