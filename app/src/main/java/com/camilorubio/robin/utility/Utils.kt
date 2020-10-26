package com.camilorubio.robin.utility

import android.content.Context
import android.graphics.Color
import android.util.TypedValue
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.camilorubio.robin.R

class Utils {

    companion object {

        fun View.gone() {
            visibility = View.GONE
        }

        fun View.visible() {
            visibility = View.VISIBLE
        }

        fun showConfirmationDialog(
            message: Int,
            isCancelable: Boolean,
            childFragmentManager: Context,
            titlePositiveButton: Int,
            titleNegativeButton: Int,
            clickTopButton: (Boolean) -> Unit
        ) {
            val dialog = AlertDialog.Builder(childFragmentManager, R.style.MyDialogTheme)
                .setMessage(message)
                .setCancelable(isCancelable)
                .setPositiveButton(titlePositiveButton) { _, _ ->
                    clickTopButton(true)
                }
                .setNegativeButton(titleNegativeButton) { dialog, _ ->
                    dialog.dismiss()
                }
                .create()

            dialog.show()

            val positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE)
            positiveButton.setTextColor(childFragmentManager.resources.getColor(R.color.purple_700))
            positiveButton.setBackgroundColor(Color.TRANSPARENT)
            positiveButton.isAllCaps = false

            val negativeButton = dialog.getButton(AlertDialog.BUTTON_NEGATIVE)
            negativeButton.setTextColor(childFragmentManager.resources.getColor(R.color.purple_700))
            negativeButton.setBackgroundColor(Color.TRANSPARENT)
            negativeButton.isAllCaps = false
        }

    }
}