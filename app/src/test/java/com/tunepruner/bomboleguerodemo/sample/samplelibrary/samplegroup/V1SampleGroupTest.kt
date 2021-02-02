package com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup

import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.LayerLogic
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.SampleLayer
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.SimpleLayerLogic
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.V1SampleLayer
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.BasicCoords
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.SampleCoords
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.V1Sample
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer.V1ZoneLayer
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer.ZoneLayer
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.Assertions.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class V1SampleGroupTest {
    lateinit var currentGroup: SampleGroup
    lateinit var layerLogic: LayerLogic
    lateinit var layerToAdd: SampleLayer
    lateinit var basicCoords: SampleCoords
    lateinit var zoneLayer: ZoneLayer

    @BeforeAll
    fun setUp() {
        currentGroup = V1SampleGroup()
        zoneLayer = V1ZoneLayer(2, 1, 1, 6)
        layerLogic = SimpleLayerLogic()
        layerToAdd = V1SampleLayer(1, layerLogic)
        basicCoords = BasicCoords(1, 1, 1, 4, 4)
        layerToAdd.addPlayable(
            basicCoords,
            V1Sample(
                basicCoords,
                "sdfjkl", layerLogic
            )
        )
        layerToAdd.addSampleCoords(1, basicCoords)
        currentGroup.addLayer(zoneLayer, layerToAdd)
    }

    @Test
    fun invokeLayer() {
        assertNotNull(currentGroup.invokeLayer(zoneLayer))
        //Currently fails because of comment in V1ZoneLayer
    }

    @Test
    fun addLayer() {
    }
}