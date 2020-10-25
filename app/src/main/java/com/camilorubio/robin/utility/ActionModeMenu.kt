package com.camilorubio.robin.utility

import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.annotation.MenuRes
import com.camilorubio.robin.R

class ActionModeMenu(private val clickSelect: (Boolean) -> Unit,
                     private val clickBack : (Boolean) -> Unit
) : ActionMode.Callback {

    private var mode: ActionMode? = null

    @MenuRes
    private var menuResId :  Int  =  0

    override fun onActionItemClicked(mode: ActionMode?, item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.select -> {
                clickSelect(true)
            }
        }
        return true
    }

    override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
        this.mode = mode
        mode?.let {
            mode.menuInflater.inflate(menuResId, menu)
        }
        return true
    }

    override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
        return false
    }

    override fun onDestroyActionMode(mode: ActionMode?) {
        clickBack(true)
        this.mode = null
    }

    fun changeTitle (text : String) {
        mode?.title = text
    }

    fun startActionMode(view: View?, @MenuRes menuResId: Int) {
        this.menuResId = menuResId
        view?.let {
            view.startActionMode(this)
        }
    }

    fun getMode() : ActionMode? {
        return mode
    }

}