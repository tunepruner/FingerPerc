package com.tunepruner.bomboleguerodemo.trigger

import android.graphics.Point
import android.graphics.PointF
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer.ZoneLayer

interface TriggerManager {
    fun computeZoneLayer(pointF: PointF): ZoneLayer
}