package com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer

import android.graphics.Point
import android.graphics.PointF

interface ZoneLayer{
    fun isMatch(pointF: PointF): Boolean
    abstract fun getZoneIteration(): Int

    fun getLayerIteration(): Int
}