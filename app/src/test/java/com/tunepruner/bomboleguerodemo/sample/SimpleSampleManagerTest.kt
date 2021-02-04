package com.tunepruner.bomboleguerodemo.sample

import com.tunepruner.bomboleguerodemo.instrument.ScreenDimensions
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.SampleLibrary
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.V1SampleLibrary
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.SampleGroup
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.V1SampleGroup
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.RoundRobinLogic
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.SampleLayer
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.SimpleRoundRobinLogic
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.V1SampleLayer
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.BasicCoords
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.SampleCoords
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer.V1ZoneLayer
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer.ZoneLayer
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class SimpleSampleManagerTest {
    lateinit var sampleManager: SimpleSampleManager
    lateinit var screenDimensions: ScreenDimensions
    lateinit var sampleLibrary: SampleLibrary
    lateinit var sampleGroupToAdd: SampleGroup
    lateinit var zoneLayerToQuery: ZoneLayer
    lateinit var sampleLayerToAdd: SampleLayer
    lateinit var basicCoords: SampleCoords
    lateinit var roundRobinLogic: RoundRobinLogic
    @BeforeEach
    fun setUp() {
        sampleLibrary = V1SampleLibrary()
        sampleGroupToAdd = V1SampleGroup()
        screenDimensions = ScreenDimensions(1000, 500)
        zoneLayerToQuery = V1ZoneLayer(2, 1, 1, 6, screenDimensions)
        roundRobinLogic = SimpleRoundRobinLogic()
        sampleLayerToAdd = V1SampleLayer(1, roundRobinLogic)
        basicCoords = BasicCoords(1, 1, 1, 4, 4)
//        sampleLayerToAdd.addPlayable(
//            basicCoords,
//            V1Sample(
//                basicCoords,
//                "sdfjkl", layerLogic
//            )
//        )
        sampleLayerToAdd.addSampleCoords(1, basicCoords)
        sampleGroupToAdd.addLayer(zoneLayerToQuery, sampleLayerToAdd)
        sampleLibrary.addSampleGroup(sampleGroupToAdd)
        sampleManager = SimpleSampleManager(sampleLibrary)
    }

    @Test
    fun computeSample() {
        assertNotNull(sampleManager.computeSample(zoneLayerToQuery))
    }
}