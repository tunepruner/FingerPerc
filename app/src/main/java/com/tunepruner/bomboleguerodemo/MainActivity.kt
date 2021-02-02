package com.tunepruner.bomboleguerodemo

import android.graphics.Insets
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.WindowInsets
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    lateinit var playableArea: PlayableArea
    var players: List<MediaPlayer> = ArrayList()

//    var playerBuilder2: SimpleExoPlayer.Builder = SimpleExoPlayer.Builder(activity)
//    var player2: ExoPlayer = playerBuilder2.build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val emptyView = PlayableArea(this, players)
        setContentView(emptyView)
    }
}



