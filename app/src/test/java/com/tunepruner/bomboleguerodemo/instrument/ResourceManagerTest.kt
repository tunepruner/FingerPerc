package com.tunepruner.bomboleguerodemo.instrument

import org.junit.jupiter.api.BeforeEach

internal class ResourceManagerTest {

    @BeforeEach
    fun setUp() {
        var preTest = 2
        var stringTest = 2.square()
    }
}

fun Int.square(): Int {
    return this * this
}