package com.tunepruner.bomboleguerodemo.trigger

import com.tunepruner.bomboleguerodemo.instrument.ResourceManager
import com.tunepruner.bomboleguerodemo.instrument.ScreenDimensions
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.TriggerGraph
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.V1TriggerGraph
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.TriggerZone
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.V1TriggerZone
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer.V1ZoneLayer
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer.ZoneLayer

class TriggerGraphFactory {
    companion object {
        fun prepareTriggers(screenDimensions: ScreenDimensions, resourceManager: ResourceManager): TriggerGraph {
            val triggerGraph: TriggerGraph = V1TriggerGraph()
            val zoneCount = resourceManager.getGroupCount()
            for (zoneIteration in 1..zoneCount) {
                val thisTriggerZone: TriggerZone = V1TriggerZone(zoneCount, zoneIteration, screenDimensions)
                val layerCount = resourceManager.getLayerCount(zoneIteration)
                for (layerIteration in 1..layerCount) {
                    val thisLayer: ZoneLayer = V1ZoneLayer(zoneCount, zoneIteration, layerIteration, layerCount, screenDimensions)
                    thisTriggerZone.addLayer(thisLayer)
                }
                triggerGraph.addTriggerZone(thisTriggerZone)
            }
            return triggerGraph
        }

    }
}