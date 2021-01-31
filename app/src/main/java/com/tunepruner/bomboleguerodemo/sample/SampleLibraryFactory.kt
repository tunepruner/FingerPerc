package com.tunepruner.bomboleguerodemo.sample

import com.tunepruner.bomboleguerodemo.instrument.ResourceManager
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.SampleLibrary
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.V1SampleLibrary
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.SampleGroup
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.V1SampleGroup
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.SampleLayer
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.V1SampleLayer
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.Playable
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.SampleCoords
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.SampleID
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.V1Sample

class SampleLibraryFactory {
    companion object {
        fun prepareSamples(): SampleLibrary {
            val sampleLibrary: SampleLibrary = V1SampleLibrary()
            val groupCount = ResourceManager.getGroupCount()
            for (groupIteration in 0..groupCount) {
                val thisSampleGroup: SampleGroup = V1SampleGroup()
                val layerCount = ResourceManager.getLayerCount(groupIteration)
                for (layerIteration in 0..layerCount) {
                    val thisSampleLayer: SampleLayer = V1SampleLayer()
                    val roundRobinCount =
                        ResourceManager.getRoundRobinCount(groupIteration, layerIteration)
                    for (roundRobinIteration in 0..roundRobinCount) {
                        val sampleID: SampleID = SampleCoords(layerIteration, roundRobinIteration)
                        val resourcePath = ResourceManager.getResource(
                            groupIteration,
                            layerIteration,
                            roundRobinIteration
                        )
                        val thisRoundRobin: Playable = V1Sample(sampleID, resourcePath)
                        thisSampleLayer.addSample(thisRoundRobin)
                    }
                    thisSampleGroup.addLayer(thisSampleLayer)
                }
                sampleLibrary.addSampleGroup(thisSampleGroup)
            }
            return sampleLibrary
        }

    }
}