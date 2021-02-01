package com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer

import android.util.Log
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.SampleCoords
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer.V1ZoneLayer
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer.ZoneLayer
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach

internal class LayerLogicTest {

    @BeforeAll
    fun setUp(){

    }

    @Test
    fun computeID() {
        var incomingLayer = V1SampleLayer(1)
        var sampleCoords = LayerLogic.computeID(incomingLayer)
        assertNotNull(sampleCoords)
    }

}