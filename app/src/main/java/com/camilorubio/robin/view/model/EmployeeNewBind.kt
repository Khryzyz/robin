package com.camilorubio.robin.view.model

import androidx.recyclerview.widget.DiffUtil

data class EmployeeNewBind (
    val id : Long,
    val name : String
) {

    object DiffCallback : DiffUtil.ItemCallback<EmployeeNewBind>() {
        override fun areItemsTheSame(
            oldItem: EmployeeNewBind,
            newItem: EmployeeNewBind
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: EmployeeNewBind,
            newItem: EmployeeNewBind
        ): Boolean {
            return oldItem == newItem
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as EmployeeBind

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}