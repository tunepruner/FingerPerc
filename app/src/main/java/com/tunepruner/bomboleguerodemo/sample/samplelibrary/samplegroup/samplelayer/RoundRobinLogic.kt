package com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer

import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.Playable
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.SampleCoords
import java.util.concurrent.ConcurrentLinkedQueue

interface RoundRobinLogic{

    fun computeID(incomingLayer: SampleLayer): SampleCoords

    fun addToHistory(playable: Playable)
}