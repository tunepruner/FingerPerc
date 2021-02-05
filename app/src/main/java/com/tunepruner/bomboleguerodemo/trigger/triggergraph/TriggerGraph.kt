package com.tunepruner.bomboleguerodemo.trigger.triggergraph

import android.graphics.PointF
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.TriggerZone
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer.LayerZone

interface TriggerGraph {
    fun invokeLayer(pointF: PointF): LayerZone?
    fun addTriggerZone(triggerZone: TriggerZone)
    fun getLayer(triggerZone: Int, zoneLayer: Int): LayerZone
}