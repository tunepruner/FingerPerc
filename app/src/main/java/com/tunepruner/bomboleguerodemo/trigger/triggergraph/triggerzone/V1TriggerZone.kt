package com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone

import android.graphics.Point
import com.tunepruner.bomboleguerodemo.instrument.ScreenDimensions
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer.ZoneLayer
import java.util.*

class V1TriggerZone(screenDimensions: ScreenDimensions) : TriggerZone {
    val zoneLayers: LinkedList<ZoneLayer> = LinkedList<ZoneLayer>()

    override fun invokeLayer(point: Point): ZoneLayer? {
        var zoneLayer: ZoneLayer? = null
        for (zoneLayerToCheck: ZoneLayer in zoneLayers) {
            if (zoneLayerToCheck.isMatch(point)) {
                zoneLayer = zoneLayerToCheck
            }
        }
        if (zoneLayer == null) throw Exception("point doesn't match any layer")
        return zoneLayer
    }


override fun addLayer(triggerLayer: ZoneLayer) {
    zoneLayers.add(triggerLayer)
}

override fun getLayer(zoneLayer: Int): ZoneLayer {
    return zoneLayers.get(zoneLayer)
}
}