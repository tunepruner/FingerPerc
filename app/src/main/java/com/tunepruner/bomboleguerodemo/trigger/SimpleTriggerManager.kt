package com.tunepruner.bomboleguerodemo.trigger

import android.graphics.Point
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.TriggerGraph
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer.ZoneLayer

class SimpleTriggerManager(private val triggerGraph: TriggerGraph): TriggerManager {
    override fun computeZoneLayer(point: Point): ZoneLayer {
        return triggerGraph.invokeLayer(point)?: error("TriggerManager called triggerGraph.invokeLayer(point) but got back a null value")
    }
}