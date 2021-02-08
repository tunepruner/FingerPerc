package com.tunepruner.bomboleguerodemo

import android.app.Activity
import android.graphics.Point
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.tunepruner.bomboleguerodemo.instrument.Instrument
import com.tunepruner.bomboleguerodemo.instrument.ScreenDimensions
import com.tunepruner.bomboleguerodemo.instrument.ScreenPrep
import java.util.*


class MainActivity : AppCompatActivity() {
    lateinit var instrument: Instrument

    override fun onCreate(savedInstanceState: Bundle?) {
        instrument = instrumentFactory(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.playable_area_2)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val point = Point()
        point.x = event.x.toInt()
        point.y = event.y.toInt()
        instrument.onTouch(event)
        guiFlicker(event)
        return true
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }

    private fun hideSystemUI() {
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN)
    }

    private fun showSystemUI() {
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
    }

    fun guiFlicker(event: MotionEvent) {
        val dimensions = ScreenPrep.getDimensions(this)
        val maskedAction = event.actionMasked
        when (maskedAction) {
            MotionEvent.ACTION_DOWN, MotionEvent.ACTION_POINTER_DOWN -> {
                if (event.y > dimensions.screenHeight / 2) {
                    var imageView: ImageView = findViewById(R.id.headImage)
                    imageView.setImageResource(R.mipmap.head_no_blur_png_foreground)
                } else {
                    var imageView: ImageView = findViewById(R.id.rimImage)
                    imageView.setImageResource(R.mipmap.rim_no_blur_png_foreground)
                }
            }
            MotionEvent.ACTION_UP, MotionEvent.ACTION_POINTER_UP -> {
                if (event.y > dimensions.screenHeight / 2) {
                    var imageView: ImageView = findViewById(R.id.headImage)
                    imageView.setImageResource(R.mipmap.head_png_foreground)
                } else {
                    var imageView: ImageView = findViewById(R.id.rimImage)
                    imageView.setImageResource(R.mipmap.rim_png_foreground)
                }
            }
        }
    }
}

fun instrumentFactory(activity: Activity): Instrument {
    return Instrument(activity)
}

