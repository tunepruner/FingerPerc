package com.tunepruner.bomboleguerodemo.trigger

import android.graphics.PointF
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer.LayerZone

interface TriggerManager {
    fun computeZoneLayer(pointF: PointF): LayerZone
}