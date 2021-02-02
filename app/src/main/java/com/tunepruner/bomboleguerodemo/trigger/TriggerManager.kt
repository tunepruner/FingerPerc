package com.tunepruner.bomboleguerodemo.trigger

import android.graphics.Point
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer.ZoneLayer

interface TriggerManager {
    fun computeZoneLayer(point: Point): ZoneLayer
}