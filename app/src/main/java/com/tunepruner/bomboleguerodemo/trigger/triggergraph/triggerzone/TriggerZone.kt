package com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone

import android.graphics.Point
import android.graphics.PointF
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer.ZoneLayer

interface TriggerZone {
    fun isMatch(pointF: PointF): Boolean
    fun invokeLayer(pointF: PointF): ZoneLayer?
    fun addLayer(triggerLayer: ZoneLayer)
    fun getLayer(zoneLayer: Int): ZoneLayer
}