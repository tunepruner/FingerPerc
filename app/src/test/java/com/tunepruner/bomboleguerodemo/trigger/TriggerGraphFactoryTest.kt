package com.tunepruner.bomboleguerodemo.trigger

import com.tunepruner.bomboleguerodemo.instrument.ScreenDimensions
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.TriggerGraph
import org.junit.jupiter.api.BeforeEach

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.verify

internal class TriggerGraphFactoryTest {
    lateinit var triggerGraph: TriggerGraph
    lateinit var screenDimensions: ScreenDimensions

    @BeforeEach
    fun setUp() {
        screenDimensions = ScreenDimensions(1000, 500)
    }

    @Test
    fun prepareTriggers() {
        triggerGraph = TriggerGraphFactory.prepareTriggers(screenDimensions)
        assertNotNull(triggerGraph.getLayer(1, 1))
    }

}