package com.tunepruner.bomboleguerodemo.sample

import com.tunepruner.bomboleguerodemo.instrument.ResourceManager
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.SampleLibrary
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.V1SampleLibrary
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.SampleGroup
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.V1SampleGroup
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.SampleLayer
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.SimpleLayerLogic
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.V1SampleLayer
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.Playable
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.BasicCoords
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.SampleCoords
import com.tunepruner.bomboleguerodemo.sample.samplelibrary.samplegroup.samplelayer.playable.V1Sample
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.TriggerGraph

class SampleLibraryFactory {
    companion object {
        fun prepareSamples(triggerGraph: TriggerGraph): SampleLibrary {
            val sampleLibrary: SampleLibrary = V1SampleLibrary()
            val groupCount = ResourceManager.getGroupCount()
            for (groupIteration in 0..groupCount) {
                val thisSampleGroup: SampleGroup = V1SampleGroup()
                val layerCount = ResourceManager.getLayerCount(groupIteration)
                for (layerIteration in 0..layerCount) {
                    val thisSampleLayer: SampleLayer = V1SampleLayer(layerIteration, SimpleLayerLogic())
                    val roundRobinCount =
                        ResourceManager.getRoundRobinCount(groupIteration, layerIteration)
                    for (roundRobinIteration in 0..roundRobinCount) {
                        val sampleCoords: SampleCoords = BasicCoords(layerIteration, roundRobinIteration, layerCount, roundRobinCount)
                        val resourcePath = ResourceManager.getResource(
                            groupIteration,
                            layerIteration,
                            roundRobinIteration
                        )
                        val thisRoundRobin: Playable = V1Sample(sampleCoords, resourcePath)
                        thisSampleLayer.addPlayable(sampleCoords, thisRoundRobin)
                        thisSampleLayer.addSampleCoords(roundRobinIteration, sampleCoords)
                    }
                    thisSampleGroup.addLayer(triggerGraph.getLayer(groupIteration, layerIteration), thisSampleLayer)
                }
                sampleLibrary.addSampleGroup(thisSampleGroup)
            }
            return sampleLibrary
        }

    }
}