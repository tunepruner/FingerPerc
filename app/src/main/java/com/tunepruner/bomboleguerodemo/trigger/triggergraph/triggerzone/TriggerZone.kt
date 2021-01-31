package com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone

import android.graphics.Point
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer.ZoneLayer

interface TriggerZone {
    fun invokeLayer(point: Point): ZoneLayer
}