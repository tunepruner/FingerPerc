package com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone

import android.graphics.Point
import com.tunepruner.bomboleguerodemo.instrument.ScreenDimensions
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer.V1ZoneLayer
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class V1TriggerZoneTest {
    lateinit var triggerZone: V1TriggerZone
    lateinit var point: Point
    lateinit var layerToAdd: V1ZoneLayer
    lateinit var screenDimensions: ScreenDimensions

    @BeforeEach
    fun setUp() {
        screenDimensions = ScreenDimensions(1000, 500)
        triggerZone = V1TriggerZone(2, 1, screenDimensions)
        layerToAdd = V1ZoneLayer(2, 1, 1, 2, screenDimensions)
        triggerZone.addLayer(layerToAdd)
        point = Point()
        point.x = 100
        point.y = 100
    }

    @Test
    fun invokeLayerNotNull() {
        assertNotNull(triggerZone.invokeLayer(point))
    }

    @Test
    fun getZoneIterationCorrectNumber() {
        assertEquals(triggerZone.invokeLayer(point)!!.getZoneIteration(), 1)
    }
}