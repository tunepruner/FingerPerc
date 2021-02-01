package com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer

import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.Playable
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.SampleCoords
import java.util.concurrent.ConcurrentLinkedQueue

class LayerLogic {

    companion object {
        private val history: ConcurrentLinkedQueue<Playable> = ConcurrentLinkedQueue<Playable>()
        private val sampleCoordsMap = HashMap<Int, SampleCoords>()

        fun computeID(incomingLayer: V1SampleLayer): SampleCoords {
            val lastPlayLayer = history.last().getSampleCoords().getLayerNumber()


            if (incomingLayer.getLayerNumber() != lastPlayLayer) {
                return sampleCoordsMap[1]!!
            }

            val totalRR = history.last().getSampleCoords().getRoundRobinCount()
            val newRR: Int = (Math.random() * ((totalRR - 1) + 1) + 1).toInt()
            return sampleCoordsMap[newRR]!!

        }

        fun addInstance(playable: Playable) {
            history.add(playable)
        }

        fun addSampleCoords(roundRobin: Int, coords: SampleCoords) {
            sampleCoordsMap[roundRobin] = coords
        }
    }

}