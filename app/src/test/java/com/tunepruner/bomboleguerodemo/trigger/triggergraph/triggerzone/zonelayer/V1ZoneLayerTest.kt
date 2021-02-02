package com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Assertions.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class V1ZoneLayerTest {

    @BeforeAll
    fun setUp() {
    }

    @Test
    fun calculateLimits() {
        var zoneLayer = V1ZoneLayer(2, 1, 1, 6, screenDimensions)
        assert(zoneLayer.getBottomLimit() > 0)
        assert(zoneLayer.getTopLimit() > 0)
        assert(zoneLayer.getLeftLimit() > 0)
        assert(zoneLayer.getRightLimit() > 0)
    }

    @Test
    fun isMatch() {
    }

    @Test
    fun getZoneIteration() {
    }
}