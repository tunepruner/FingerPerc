package com.tunepruner.bomboleguerodemo.sample.samplelibrary

import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.SampleGroup
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.V1SampleGroup
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.LayerLogic
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.SampleLayer
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.SimpleLayerLogic
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.V1SampleLayer
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.BasicCoords
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.SampleCoords
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.V1Sample
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer.V1ZoneLayer
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer.ZoneLayer
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.TestInstance

import org.junit.jupiter.api.BeforeAll

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class V1SampleLibraryTest {
    lateinit var sampleLibrary: SampleLibrary
    lateinit var groupToAdd: SampleGroup
    lateinit var zoneLayerToQuery: ZoneLayer
    lateinit var layerToAdd: SampleLayer
    lateinit var basicCoords: SampleCoords
    lateinit var layerLogic: LayerLogic
    @BeforeAll
    fun setUp() {
        sampleLibrary = V1SampleLibrary()
        groupToAdd = V1SampleGroup()
        zoneLayerToQuery = V1ZoneLayer(2, 1, 1, 6, screenDimensions)
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
        groupToAdd.addLayer(zoneLayerToQuery, layerToAdd)
        sampleLibrary.addSampleGroup(groupToAdd)
    }

    @Test
    fun computeSampleReturnsNotNull() {
        assertNotNull(sampleLibrary.computeSample(zoneLayerToQuery))
    }

    @Test
    fun addSampleGroup() {
    }
}