package com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer

import com.tunepruner.bomboleguerodemo.instrument.ScreenDimensions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Assertions.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class V1ZoneLayerTest {
    lateinit var screenDimensions: ScreenDimensions

    @BeforeAll
    fun setUp() {
        screenDimensions = ScreenDimensions(1000, 500)
    }

    @Test
    fun calculateLimits() {
        var zoneLayer = V1ZoneLayer(2, 1, 1, 6, screenDimensions)
        assert(zoneLayer.getBottomLimit() > 0)
        assert(zoneLayer.getTopLimit() == 0)
        assert(zoneLayer.getLeftLimit() == 0)
        assert(zoneLayer.getRightLimit() == 500)
    }

    @Test
    fun isMatch() {
    }

    @Test
    fun getZoneIteration() {
    }
}