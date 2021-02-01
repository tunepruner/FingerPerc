package com.tunepruner.bomboleguerodemo.trigger.triggergraph

import android.graphics.Point
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.TriggerZone
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.V1TriggerZone
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer.ZoneLayer
import java.util.LinkedList;

class V1TriggerGraph : TriggerGraph {
    val zones: LinkedList<TriggerZone> = LinkedList<TriggerZone>()

    override fun invokeLayer(point: Point): ZoneLayer? {
        var zone: TriggerZone?
        if (point.y > 900)
            zone = zones.get(0)
        else
            zone = zones.get(1)
        return zone.invokeLayer(point)
    }

    override fun getLayer(triggerZone: Int, zoneLayer: Int): ZoneLayer {
        return zones.get(triggerZone).getLayer(zoneLayer)
    }

    override fun addTriggerZone(triggerZone: TriggerZone) {
        zones.add(triggerZone)
    }
}