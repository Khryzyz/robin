package com.camilorubio.robin.view.model

import androidx.recyclerview.widget.DiffUtil

data class BossEmployeeBind (
    val id : Long,
    val name : String,
    val position : String,
    val wage : Long
) {

    object DiffCallback : DiffUtil.ItemCallback<BossEmployeeBind>() {
        override fun areItemsTheSame(
            oldItem: BossEmployeeBind,
            newItem: BossEmployeeBind
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: BossEmployeeBind,
            newItem: BossEmployeeBind
        ): Boolean {
            return oldItem == newItem
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BossEmployeeBind

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}