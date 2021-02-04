package com.tunepruner.bomboleguerodemo.instrument

import android.graphics.Point
import android.graphics.PointF
import android.view.MotionEvent

interface TouchLogic {
    fun reduceTouchEvent(event: MotionEvent): PointF?


}
