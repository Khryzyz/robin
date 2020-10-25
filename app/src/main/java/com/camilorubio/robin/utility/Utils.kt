package com.camilorubio.robin.utility

import android.view.View

class Utils {

    companion object {

        fun View.gone() {
            visibility = View.GONE
        }

        fun View.visible() {
            visibility = View.VISIBLE
        }

    }
}