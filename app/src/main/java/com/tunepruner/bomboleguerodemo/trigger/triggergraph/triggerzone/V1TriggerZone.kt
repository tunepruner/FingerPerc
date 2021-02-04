package com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone

import android.graphics.Point
import android.graphics.PointF
import com.tunepruner.bomboleguerodemo.instrument.ScreenDimensions
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer.ZoneLayer
import java.util.*

class V1TriggerZone(
    val zoneCount: Int,
    val zoneIteration: Int,
    val screenDimensions: ScreenDimensions
) : TriggerZone {
    private val zoneLayers: LinkedList<ZoneLayer> = LinkedList<ZoneLayer>()
    var leftLimit: Int = 0
    var rightLimit: Int = 0
    var topLimit: Int = 0
    var bottomLimit: Int = 0

    init {
        calculateLimits(zoneCount, zoneIteration)
    }

    private fun calculateLimits(zoneCount: Int, zoneIteration: Int) {
        /* Deriving top limit of this TriggerZone from (height of a zone) * (number of preceding ones) */
        val thisZoneHeight = screenDimensions.screenHeight / zoneCount
        topLimit = thisZoneHeight * (zoneIteration - 1)
        bottomLimit = topLimit + thisZoneHeight

        leftLimit = 0
        rightLimit = screenDimensions.screenWidth
    }

    override fun isMatch(pointF: PointF): Boolean {
        return pointF.x.toInt() in (leftLimit + 1)..rightLimit &&
                pointF.y.toInt() in (topLimit + 1)..bottomLimit
    }

    override fun invokeLayer(pointF: PointF): ZoneLayer {
        var zoneLayer: ZoneLayer? = null
        for (element in zoneLayers) {
            if (element.isMatch(pointF)) {
                zoneLayer = element
            }
        }
        return zoneLayer
            ?: error("V1TriggerZone looked for match layer in it's implementation, but didn't find a layer that contains that point")
    }


    override fun addLayer(triggerLayer: ZoneLayer) {
        zoneLayers.add(triggerLayer)
    }

    override fun getLayer(zoneLayer: Int): ZoneLayer {
        return zoneLayers[zoneLayer-1]
    }
}