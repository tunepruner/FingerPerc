package com.tunepruner.bomboleguerodemo.trigger.triggergraph

import android.graphics.Point
import android.graphics.PointF
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.TriggerZone
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer.ZoneLayer

interface TriggerGraph {
    fun invokeLayer(pointF: PointF): ZoneLayer?
    fun addTriggerZone(triggerZone: TriggerZone)
    fun getLayer(triggerZone: Int, zoneLayer: Int): ZoneLayer
}