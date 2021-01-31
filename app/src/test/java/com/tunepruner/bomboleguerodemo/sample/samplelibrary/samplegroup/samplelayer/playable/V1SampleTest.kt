package com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable

import org.mockito.Mockito
import org.mockito.Mockito.verify

internal class V1SampleTest {
    lateinit var mockedV1Sample: V1Sample
    lateinit var mockedSampleID: SampleID
    var realSampleID: SampleID = SampleCoords(1, 1)
    var realV1Sample: V1Sample = V1Sample(realSampleID)
    var realSimpleSampleWithMockSampleID = V1Sample(mockedSampleID)

    @org.junit.jupiter.api.BeforeEach
    fun setUp() {
        mockedSampleID = Mockito.mock(SampleID::class.java)
        mockedV1Sample = Mockito.mock(V1Sample::class.java)
    }

    @org.junit.jupiter.api.Test
    fun play() {
        mockedV1Sample.play()
        verify(mockedV1Sample).play()
    }

    @org.junit.jupiter.api.Test
    fun getSampleID() {
    }
}