package com.camilorubio.robin.view.employee.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.camilorubio.robin.databinding.BossEmployeeItemBinding
import com.camilorubio.robin.view.model.BossEmployeeBind

class BossEmployeeAdapter(private val clickListener: (Long) -> Unit) :
    ListAdapter<BossEmployeeBind,
            BossEmployeeAdapter.BossEmployeeViewHolder>(BossEmployeeBind.DiffCallback){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BossEmployeeViewHolder {
        return BossEmployeeViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: BossEmployeeViewHolder, position: Int) {
        val bossEmployee = getItem(position)
        holder.bind(bossEmployee, clickListener)
    }

    class BossEmployeeViewHolder private constructor(
        private val binding: BossEmployeeItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(bossEmployee: BossEmployeeBind, clickListener: (Long) -> Unit) {
            binding.apply {
                boss = bossEmployee

                container.setOnClickListener {
                    clickListener(bossEmployee.id)
                }

                executePendingBindings()
            }
        }

        companion object {
            fun from(parent: ViewGroup): BossEmployeeViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = BossEmployeeItemBinding.inflate(
                    layoutInflater,
                    parent,
                    false
                )

                return BossEmployeeViewHolder(binding)
            }
        }
    }

}