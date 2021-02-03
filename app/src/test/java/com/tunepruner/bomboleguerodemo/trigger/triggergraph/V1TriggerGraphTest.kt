package com.tunepruner.bomboleguerodemo.trigger.triggergraph

import android.graphics.Point
import com.tunepruner.bomboleguerodemo.instrument.ScreenDimensions
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.V1TriggerZone
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer.V1ZoneLayer
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class V1TriggerGraphTest {
    lateinit var triggerGraph: TriggerGraph
    lateinit var triggerZone1ToAdd: V1TriggerZone
    lateinit var triggerZone2ToAdd: V1TriggerZone
    lateinit var point: Point
    lateinit var layerToAdd: V1ZoneLayer
    lateinit var screenDimensions: ScreenDimensions
    @BeforeEach
    fun setUp() {
        screenDimensions = ScreenDimensions(1000, 500)
        triggerGraph = V1TriggerGraph()
        triggerZone1ToAdd = V1TriggerZone(2, 1, screenDimensions)
        triggerZone2ToAdd = V1TriggerZone(2, 2, screenDimensions)
        triggerGraph.addTriggerZone(triggerZone1ToAdd)
        triggerGraph.addTriggerZone(triggerZone2ToAdd)
        layerToAdd = V1ZoneLayer(2, 1, 1, 2, screenDimensions)
        triggerZone1ToAdd.addLayer(layerToAdd)
        triggerZone2ToAdd.addLayer(layerToAdd)
        point = Point()
        point.x = 100
        point.y = 100
    }

    @Test
    fun invokeLayer() {
        assertNotNull(triggerGraph.invokeLayer(point))
    }
}