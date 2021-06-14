package fr.mappy.fizzbuzz.utils

import android.text.Editable
import android.view.View

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
