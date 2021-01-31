package com.tunepruner.bomboleguerodemo.trigger

import com.tunepruner.bomboleguerodemo.instrument.ResourceManager
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.TriggerGraph
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.V1TriggerGraph
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.TriggerZone
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.V1TriggerZone
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer.V1ZoneLayer
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer.ZoneLayer

class TriggerGraphFactory {
    companion object {
        fun prepareTriggers(): TriggerGraph {
            val triggerGraph: TriggerGraph = V1TriggerGraph()
            val zoneCount = ResourceManager.getGroupCount()
            for (zoneIteration in 0..zoneCount) {
                val thisTriggerZone: TriggerZone = V1TriggerZone()
                val layerCount = ResourceManager.getLayerCount(zoneIteration)
                for (layerIteration in 0..layerCount) {
                    val thisLayer: ZoneLayer = V1ZoneLayer()
                    thisTriggerZone.addLayer(thisLayer)
                }
                triggerGraph.addTriggerZone(thisTriggerZone)
            }
            return triggerGraph
        }
    }
}