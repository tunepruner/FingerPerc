package com.tunepruner.bomboleguerodemo.instrument

import android.graphics.Point
import android.view.MotionEvent
import androidx.core.graphics.toPointF
import java.time.LocalTime
import java.util.*
import java.util.concurrent.ConcurrentLinkedQueue
import kotlin.math.pow
import kotlin.math.sqrt

class SimpleTouchLogic : TouchLogic {
    val historyOfRequests: ConcurrentLinkedQueue<Point> =
        ConcurrentLinkedQueue<Point>()//TODO investigate if there might be a better choice for these.
    val historyOfReturns: ConcurrentLinkedQueue<Point> = ConcurrentLinkedQueue<Point>()
    var lastTimeStamp = Calendar.getInstance().timeInMillis;

    override fun reduceTouchEvent(x: Float, y: Float): Point? {
        val point = Point()
        point.x = x.toInt()
        point.y = y.toInt()
        historyOfRequests.add(point)

        return if (isDifferentFinger()) {
            historyOfReturns.add(point)
            lastTimeStamp = Calendar.getInstance().timeInMillis;
            point
        } else
            null
    }

    private fun isDifferentFinger(): Boolean {
        if (historyOfReturns.isEmpty())
            return true
        val distance = sqrt(
            (historyOfRequests.last().x.toDouble() - historyOfReturns.last().x).pow(2.0)
                    +
                    (historyOfRequests.last().y.toDouble() - historyOfReturns.last().x).pow(
                        2.0
                    )
        )
        return distance > 100 && enoughTimePassed()
    }

    private fun enoughTimePassed(): Boolean {
        val timeNow: Long = Calendar.getInstance().timeInMillis;
        return timeNow - lastTimeStamp > 100
    }


}
