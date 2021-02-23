package com.tunepruner.fingerperc.sample.samplelibrary.articulation

import com.tunepruner.fingerperc.sample.samplelibrary.articulation.velocitylayer.VelocityLayer
import com.tunepruner.fingerperc.sample.samplelibrary.articulation.velocitylayer.sample.Sample
import com.tunepruner.fingerperc.zone.zonegraph.articulationzone.velocityzone.VelocityZone

interface Articulation {
    fun computeSample(velocityZone: VelocityZone): Sample
    fun addLayer(velocityZone: VelocityZone, velocityLayer: VelocityLayer)
}