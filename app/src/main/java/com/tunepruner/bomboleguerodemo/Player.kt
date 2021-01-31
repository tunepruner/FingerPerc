package com.tunepruner.bomboleguerodemo

import android.app.Activity
import android.content.Context
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

class Player(val context: Context) : AppCompatActivity() {
    lateinit var resourceIDs: List<Int>
    val velocityLevels: Map<Int, List<Int>> = HashMap()

    init {
        prepareSamples()
    }

    fun prepareSamples() {
//        var strings: String[] = AssetManager.list("src/main/assets/bombo/borde/borde_10_1.wav")
//        val assetMgr = assets
//
//        val assetsIWant = assetMgr.list("subdir")
//
//        for (asset in assetsIWant!!) {
//            doAssetyThing(asset)
//        }
        for (i in 1..31) {
//            var inty: Int = R.raw.centro_15_1/*
//            var string: String = getResources().getResourceName(inty);
//            var mp = MediaPlayer.create(this, inty)
//            (players as ArrayList<MediaPlayer>).add(mp)*/
//            var inty: Int
//            if (i == 0) inty = R.raw.centro_10_1
//            else if (i == 1) inty = R.raw.centro_11_1
//            else if (i == 2) inty = R.raw.centro_12_1
//            else if (i == 3) inty = R.raw.centro_13_1
//            else if (i == 4) inty = R.raw.centro_14_1
//            else if (i == 5) inty = R.raw.centro_15_1
//            else if (i == 6) inty = R.raw.centro_16_1
//            else if (i == 7) inty = R.raw.centro_17_1
//            else if (i == 8) inty = R.raw.centro_18_1
//            else if (i == 9) inty = R.raw.centro_19_1
//            else inty = R.raw.centro_20_1
//            var string: String = getResources().getResourceName(inty);
//            var mp = MediaPlayer.create(this, inty)
//            (players as ArrayList<MediaPlayer>).add(mp)
        }
    }

    fun prepareResourceIDs(){
        /*Figure out how many levels; store in amountOfLevels
        * for (i in 0..amountOfLevels) ..
        *       make a new List<Int> and store all the resource IDs that correspond to that level*/
    }

    fun getResourceID(){}

    fun playSample(velocity: Int) = runBlocking {
//        var mp = MediaPlayer.create(context, /*insert ResouceID here*/)
//        val thread = async {
//            mp.start()
//        }
//        thread.await()
    }
}