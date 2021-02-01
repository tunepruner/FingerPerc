package com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer

import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.Playable
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.SampleCoords
import java.util.concurrent.ConcurrentLinkedQueue

class SimpleLayerLogic : LayerLogic {
    private var history: ConcurrentLinkedQueue<Playable> = ConcurrentLinkedQueue<Playable>()

    override fun computeID(incomingLayer: SampleLayer): SampleCoords {
        if (!history.isEmpty()) {
            if (incomingLayer.getLayerNumber() !=
                history.last().getSampleCoords().getLayerNumber()
            ) {
                return incomingLayer.getSampleIDByInt(1)
            }
        }
        val totalRR = incomingLayer.getSampleIDByInt(1).getRoundRobinCount()
        val newRR: Int = (Math.random() * ((totalRR - 1) + 1) + 1).toInt()
        return incomingLayer.getSampleIDByInt(newRR)
    }

    override fun addToHistory(playable: Playable) {
        history.add(playable)
    }
}

