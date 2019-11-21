package com.devcoder.mvvmexample.utils

import android.content.Context
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast


fun showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
}

fun ProgressBar.show() {
    visibility = View.VISIBLE
}

fun ProgressBar.hide() {
    visibility = View.GONE
}