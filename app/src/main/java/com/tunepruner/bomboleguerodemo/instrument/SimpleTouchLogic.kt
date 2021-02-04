package com.tunepruner.bomboleguerodemo.instrument

import android.graphics.Point
import android.util.Log
import java.util.*
import java.util.concurrent.ConcurrentLinkedQueue
import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.properties.Delegates

class SimpleTouchLogic : TouchLogic {
    private val requests: ConcurrentLinkedQueue<Point> =
        ConcurrentLinkedQueue<Point>()//TODO investigate if there might be a better choice for these.
    private val returns: ConcurrentLinkedQueue<Point> = ConcurrentLinkedQueue<Point>()
    var lastTime = Calendar.getInstance().timeInMillis;
    var timeNow by Delegates.notNull<Long>()

    override fun reduceTouchEvent(x: Float, y: Float): Point? {
        val point = Point()
        point.x = x.toInt()
        point.y = y.toInt()
        requests.add(point)
        timeNow = Calendar.getInstance().timeInMillis
        val enoughTimePassed = timeNow - lastTime > 100

        return if (isFarAway(x, y)) {
            returns.add(point)
            lastTime = Calendar.getInstance().timeInMillis;

            point
        } else if (!isFarAway(x, y) &&
            enoughTimePassed
        ) {
            returns.add(point)
            lastTime = Calendar.getInstance().timeInMillis;
            point
        } else {
            null
        }
    }

    private fun isFarAway(x: Float, y: Float): Boolean {
        if (returns.isEmpty()) {
            return true
        }
        val side1 = x.toDouble() - returns.last().x
        val side2 = y.toDouble() - returns.last().y

        val distance = sqrt(side1.pow(2.0) + side2.pow(2.0))
        return distance > 500
    }
}
