package com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer

import android.util.Log
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class LayerLogicTest {

    @Test
    fun testMath() {
        var integerTest = LayerLogic.testMath(5)
        Log.i("randomTest", integerTest.toString())
        assert(true)
    }
}