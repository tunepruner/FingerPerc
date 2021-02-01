package com.tunepruner.bomboleguerodemo.trigger

import android.graphics.Point
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.TriggerGraph
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer.ZoneLayer

class SimpleTriggerManager(val triggerGraph: TriggerGraph): TriggerManager {
    override fun computeZoneLayer(point: Point): ZoneLayer? {
        return triggerGraph.invokeLayer(point)
    }
}