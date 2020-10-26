package com.camilorubio.robin.view.employeeNew.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.camilorubio.robin.databinding.EmployeeNewItemBinding
import com.camilorubio.robin.view.model.EmployeeNewBind

class EmployeeNewAdapter :
    ListAdapter<EmployeeNewBind, EmployeeNewAdapter.EmployeeNewViewHolder>(EmployeeNewBind.DiffCallback){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EmployeeNewViewHolder {
        return EmployeeNewViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: EmployeeNewViewHolder, position: Int) {
        val employeeNew = getItem(position)
        holder.bind(employeeNew)
    }

    class EmployeeNewViewHolder private constructor(
        private val binding: EmployeeNewItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(employeeNew: EmployeeNewBind) {
            binding.apply {
                employeeNewBind = employeeNew

                executePendingBindings()
            }
        }

        companion object {
            fun from(parent: ViewGroup): EmployeeNewViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = EmployeeNewItemBinding.inflate(
                    layoutInflater,
                    parent,
                    false
                )

                return EmployeeNewViewHolder(binding)
            }
        }
    }

}