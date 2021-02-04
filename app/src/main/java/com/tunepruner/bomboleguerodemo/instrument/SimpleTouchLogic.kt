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
//            Log.i("testtt", "isFarAway")
//            Log.i("testtt", "last returned x: ${returns.last().x}")
//            Log.i("testtt", "last returned y: ${returns.last().y}")
//            Log.i("testtt", "this x: $x")
//            Log.i("testtt", "this y: $y")

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
            Log.i("testtt", "Returns is empty")
            return true
        }
        Log.i("testtt", "------------------")
        Log.i("testtt", "returns.last x = ${returns.last().x}")
        Log.i("testtt", "returns.last y = ${returns.last().y}")
        Log.i("testtt","x = $x")
        Log.i("testtt","y = $y")
        val side1 = x.toDouble() - returns.last().x
        Log.i("testtt", "side1 = $side1")
        val side2 = y.toDouble() - returns.last().y
        Log.i("testtt", "side2 = $side2")

        val distance = sqrt(side1.pow(2.0) + side2.pow(2.0))
        Log.i("testtt", "distance = $distance")
        Log.i("testtt", "is greater? ${distance > 300}")
        Log.i("testtt", "------------------")
        return distance > 300
    }
}
