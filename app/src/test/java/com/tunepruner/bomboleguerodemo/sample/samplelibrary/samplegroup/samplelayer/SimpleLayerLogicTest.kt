package com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer

import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.BasicCoords
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

internal class SimpleLayerLogicTest {

    @BeforeEach
    fun setUp() {
        SimpleLayerLogic.addSampleCoords(1, BasicCoords(1, 1, 3, 4))
    }

    @Test
    fun thatComputeIDReturnsAValue() {
        var incomingLayer = V1SampleLayer(1)

        var sampleCoords = SimpleLayerLogic.computeID(incomingLayer)
        assertNotNull(sampleCoords)
    }

    @Test
    fun computeIDReturns() {
        SimpleLayerLogic.addSampleCoords(1, BasicCoords(1, 1, 3, 4))
        var incomingLayer = V1SampleLayer(1)

        var sampleCoords = SimpleLayerLogic.computeID(incomingLayer)
        assertNotNull(sampleCoords)
    }

}