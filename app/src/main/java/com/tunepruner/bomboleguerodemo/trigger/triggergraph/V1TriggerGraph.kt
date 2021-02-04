package com.tunepruner.bomboleguerodemo.trigger.triggergraph

import android.graphics.Point
import android.graphics.PointF
import android.util.Log
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.TriggerZone
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.V1TriggerZone
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer.ZoneLayer
import java.util.LinkedList;

class V1TriggerGraph : TriggerGraph {
    val zones: LinkedList<TriggerZone> = LinkedList<TriggerZone>()

    override fun invokeLayer(pointF: PointF): ZoneLayer {

        var triggerZone: TriggerZone? = null
        for (element in zones) {
            if (element.isMatch(pointF)) {
                triggerZone = element
            }
        }
        triggerZone?: error("TriggerManager called triggerGraph.invokeLayer(point) but got back a null value")
        return triggerZone.invokeLayer(pointF)?: error("TriggerGraph called triggerZone.invokeLayer(point) but got back a null value")
    }

    override fun getLayer(triggerZone: Int, zoneLayer: Int): ZoneLayer {
        return zones[triggerZone-1].getLayer(zoneLayer)
    }

    override fun addTriggerZone(triggerZone: TriggerZone) {
        zones.add(triggerZone)
    }
}