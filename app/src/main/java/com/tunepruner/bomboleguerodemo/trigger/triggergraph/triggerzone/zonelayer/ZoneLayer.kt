package com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer

import android.graphics.Point

interface ZoneLayer{
    fun isMatch(point: Point): Boolean
    fun getZoneIteration(): Int
    abstract fun getBottomLimit(): Any
    abstract fun getTopLimit(): Any
    abstract fun getLeftLimit(): Any
    abstract fun getRightLimit(): Any
}