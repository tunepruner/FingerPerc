package com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone

import android.graphics.PointF
import com.tunepruner.bomboleguerodemo.instrument.ScreenDimensions
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer.LayerZone
import java.util.*

class V1TriggerZone(
    val zoneCount: Int,
    val zoneIteration: Int,
    val screenDimensions: ScreenDimensions
) : TriggerZone {
    private val layerZones: LinkedList<LayerZone> = LinkedList<LayerZone>()
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

    override fun invokeLayer(pointF: PointF): LayerZone {
        var layerZone: LayerZone? = null
        for (element in layerZones) {
            if (element.isMatch(pointF)) {
                layerZone = element
            }
        }
        return layerZone
            ?: error("V1TriggerZone looked for match layer in it's implementation, but didn't find a layer that contains that point")
    }


    override fun addLayer(triggerLayerZone: LayerZone) {
        layerZones.add(triggerLayerZone)
    }

    override fun getLayer(zoneLayer: Int): LayerZone {
        return layerZones[zoneLayer-1]
    }
}