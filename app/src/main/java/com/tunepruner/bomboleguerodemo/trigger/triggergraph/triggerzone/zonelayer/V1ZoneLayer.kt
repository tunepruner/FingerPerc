package com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer

import android.graphics.Point
import com.tunepruner.bomboleguerodemo.instrument.ScreenDimensions

class V1ZoneLayer(
    private val zoneCount: Int,
    private val zoneIteration: Int,
    private val layerIteration: Int,
    private val layerCountOfZone: Int,
    val screenDimensions: ScreenDimensions
) : ZoneLayer {
    private var leftLimit: Int = 0
    private var rightLimit: Int = 0
    private var topLimit: Int = 0
    private var bottomLimit: Int = 0

    init {
        calculateLimits(zoneCount, zoneIteration, layerIteration, layerCountOfZone)
    }

    override fun isMatch(point: Point): Boolean {
        return point.x in (leftLimit + 1)..rightLimit &&
                point.y in (topLimit + 1)..bottomLimit
    }

    private fun calculateLimits(
        zoneCount: Int,
        zoneIteration: Int,
        layerIteration: Int,
        layerCountOfZone: Int
    ){
        /* Deriving top limit of this TriggerZone from (height of a zone) * (number of preceding ones) */
        val thisZoneHeight = screenDimensions.screenHeight / zoneCount
        val zoneTopLimit = thisZoneHeight * (zoneIteration - 1)

        /* Deriving top limit of this ZoneLayer from (height of a layer) * (number of preceding ones) */
        val thisLayerHeight = thisZoneHeight / layerCountOfZone
        topLimit = thisLayerHeight * (layerIteration - 1)

        bottomLimit = topLimit + thisLayerHeight

        leftLimit = 0
        rightLimit = screenDimensions.screenWidth
    }

    override fun getZoneIteration(): Int {
        return zoneIteration
    }

    override fun getBottomLimit(): Int {
        return bottomLimit
    }

    override fun getTopLimit(): Int {
        return topLimit
    }

    override fun getLeftLimit(): Int {
        return leftLimit
    }

    override fun getRightLimit(): Int {
        return rightLimit
    }
}