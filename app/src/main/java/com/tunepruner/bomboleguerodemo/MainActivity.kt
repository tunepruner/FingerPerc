package com.tunepruner.bomboleguerodemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    lateinit var playableArea: PlayableArea


//    var playerBuilder2: SimpleExoPlayer.Builder = SimpleExoPlayer.Builder(activity)
//    var player2: ExoPlayer = playerBuilder2.build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        playableArea = PlayableArea(this)
        setContentView(playableArea)
    }
}



