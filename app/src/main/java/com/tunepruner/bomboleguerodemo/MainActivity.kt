package com.tunepruner.bomboleguerodemo

import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    lateinit var playableArea: PlayableArea
    var players: List<MediaPlayer> = ArrayList()

//    var playerBuilder2: SimpleExoPlayer.Builder = SimpleExoPlayer.Builder(activity)
//    var player2: ExoPlayer = playerBuilder2.build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        val principalView = PlayableArea(this, players)
        setContentView(principalView)
    }





}

/*TODO
*  Create Map (velocityLevels) of Lists<Int>(resourceIDs)
*  Create logic to create each List<Int>(must read filenames)
*  Create logic
* */