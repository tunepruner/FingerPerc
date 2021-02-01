package com.tunepruner.bomboleguerodemo.trigger.triggergraph

import android.graphics.Point
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.TriggerZone
import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer.ZoneLayer

interface TriggerGraph {
    fun invokeLayer(point: Point): ZoneLayer?
    fun addTriggerZone(triggerZone: TriggerZone)
}