package com.camilorubio.robin.view.employee.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.camilorubio.robin.databinding.EmployeeItemBinding
import com.camilorubio.robin.view.model.EmployeeBind

class EmployeeAdapter :
    ListAdapter<EmployeeBind, EmployeeAdapter.EmployeeViewHolder>(EmployeeBind.DiffCallback){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EmployeeViewHolder {
        return EmployeeViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val employee = getItem(position)
        holder.bind(employee)
    }

    class EmployeeViewHolder private constructor(
        private val binding: EmployeeItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(employee: EmployeeBind) {
            binding.apply {
                employeeBind = employee

                executePendingBindings()
            }
        }

        companion object {
            fun from(parent: ViewGroup): EmployeeViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = EmployeeItemBinding.inflate(
                    layoutInflater,
                    parent,
                    false
                )

                return EmployeeViewHolder(binding)
            }
        }
    }

}