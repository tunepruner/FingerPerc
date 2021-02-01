package com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer

import android.graphics.Point

class V1ZoneLayer(val zoneCount: Int, val zoneIteration: Int, val layerIteration: Int, val layerCountOfZone: Int): ZoneLayer{
    lateinit var leftLimit: Int
    lateinit var rightLimit: Int
    lateinit var topLimit: Int
    lateinit var bottomLimit: Int

    init {
        calculateLimits(zoneCount, zoneIteration, layerIteration, layerCountOfZone)
    }

    override fun isMatch(point: Point): Boolean{
        return point.x in (leftLimit + 1)..rightLimit &&
                point.y in (topLimit +1)..bottomLimit
    }

    private fun calculateLimits(
        zoneCount: Int,
        zoneIteration: Int,
        layerIteration: Int,
        layerCountOfZone: Int): Int {

        /* Deriving top limit of this TriggerZone from (height of a zone) * (number of preceding ones) */
        val screenHeight: Int = /*TODO get Android screen height*/
        val thisZoneHeight = screenHeight / zoneCount
        val zoneTopLimit = thisZoneHeight * (zoneIteration-1)

        /* Deriving top limit of this ZoneLayer from (height of a layer) * (number of preceding ones) */
        val thisLayerHeight = thisZoneHeight / layerCountOfZone
        topLimit = thisLayerHeight * (layerIteration-1)

        bottomLimit = topLimit + thisLayerHeight

        leftLimit = 0
        rightLimit = /*Todo get Android screen width*/

    }
}