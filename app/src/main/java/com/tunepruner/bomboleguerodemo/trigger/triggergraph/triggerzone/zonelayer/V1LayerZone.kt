package com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer

import android.graphics.PointF
import com.tunepruner.bomboleguerodemo.instrument.ScreenDimensions

class V1LayerZone(
    private val zoneCount: Int,
    private val zoneIteration: Int,
    private val layerIteration: Int,
    private val layerCountOfZone: Int,
    val screenDimensions: ScreenDimensions
) : LayerZone {
    private var zoneLimits: ZoneLimits

    init {
        zoneLimits = calculateLimits()
    }

    override fun isMatch(pointF: PointF): Boolean {
        return pointF.x.toInt() in (zoneLimits.leftLimit + 1)..zoneLimits.rightLimit &&
                pointF.y.toInt() in (zoneLimits.topLimit + 1)..zoneLimits.bottomLimit
    }

    override fun getZoneIteration(): Int {
        return zoneIteration
    }

    override fun getLayerIteration(): Int {
        return layerIteration
    }

    override fun getLimits(): ZoneLimits {
        return zoneLimits
    }

    private fun calculateLimits(): ZoneLimits{
        /* Deriving top limit of this TriggerZone from (height of a zone) * (number of preceding ones) */
        val thisZoneHeight = screenDimensions.screenHeight / zoneCount
        val zoneTopLimit = thisZoneHeight * (zoneIteration - 1)

        /* Deriving top limit of this ZoneLayer from (height of a layer) * (number of preceding ones) */
        val thisLayerHeight = thisZoneHeight / layerCountOfZone
        val topLimit = zoneTopLimit + thisLayerHeight * (layerIteration - 1)

        val bottomLimit = topLimit + thisLayerHeight

        val leftLimit = 0
        val rightLimit = screenDimensions.screenWidth
        return ZoneLimits(leftLimit, rightLimit, topLimit, bottomLimit)

    }
}

data class ZoneLimits(val leftLimit: Int, val rightLimit: Int, val topLimit: Int, val bottomLimit: Int)