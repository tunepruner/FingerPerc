package com.tunepruner.bomboleguerodemo.instrument

import android.graphics.Point
import android.view.MotionEvent

interface TouchLogic {
    fun reduceTouchEvent(x: Float, y: Float): Point?


}
