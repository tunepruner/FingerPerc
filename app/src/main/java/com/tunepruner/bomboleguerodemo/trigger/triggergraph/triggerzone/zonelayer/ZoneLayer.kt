package com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer

import android.graphics.Point

interface ZoneLayer{
    fun isMatch(point: Point): Boolean
    abstract fun getZoneIteration(): Int

}