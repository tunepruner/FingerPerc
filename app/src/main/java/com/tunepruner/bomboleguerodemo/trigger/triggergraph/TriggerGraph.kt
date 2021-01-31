package com.tunepruner.bomboleguerodemo.trigger.triggergraph

import com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer.ZoneLayer

interface TriggerGraph {
    fun invokeLayer(): ZoneLayer
}