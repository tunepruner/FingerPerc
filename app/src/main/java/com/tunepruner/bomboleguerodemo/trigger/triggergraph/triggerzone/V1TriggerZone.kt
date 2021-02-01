package com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone

import android.graphics.Point
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer.ZoneLayer
import java.util.*

class V1TriggerZone: TriggerZone {
    val triggerLayers: LinkedList<ZoneLayer> = LinkedList<ZoneLayer>()
    override fun invokeLayer(point: Point): ZoneLayer? {
        for (zoneLayer: ZoneLayer in triggerLayers) {
            if (zoneLayer.isMatch(point)) {
                return zoneLayer
            }
        }
        return null
    }

    override fun addLayer(triggerLayer: ZoneLayer) {
        triggerLayers.add(triggerLayer)
    }
}