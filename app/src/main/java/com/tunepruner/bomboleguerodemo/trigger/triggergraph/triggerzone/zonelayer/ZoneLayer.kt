package com.tunepruner.bomboleguerodemo.trigger.triggergraph.triggerzone.zonelayer

import android.graphics.Point

interface ZoneLayer {
    fun getLayer(point: Point): ZoneLayer
}