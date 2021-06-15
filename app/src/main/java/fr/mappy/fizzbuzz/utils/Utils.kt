package fr.mappy.fizzbuzz.utils

import android.app.Activity
import android.graphics.Insets
import android.os.Build
import android.text.Editable
import android.util.DisplayMetrics
import android.view.View
import android.view.WindowInsets


fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

fun Editable?.toInt(): Int? {
    if (this == null) {
        return null
    }
    return try {
        Integer.valueOf(toString())
    } catch (e: NumberFormatException) {
        null
    }
}

fun Activity.getScreenWidthPixels(): Int {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        val windowMetrics = this.windowManager.currentWindowMetrics
        val insets: Insets = windowMetrics.windowInsets
            .getInsetsIgnoringVisibility(WindowInsets.Type.systemBars())
        windowMetrics.bounds.width() - insets.left - insets.right
    } else {
        val displayMetrics = DisplayMetrics()
        this.windowManager.defaultDisplay.getMetrics(displayMetrics)
        displayMetrics.widthPixels
    }
}
