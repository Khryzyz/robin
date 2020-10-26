package com.camilorubio.robin.view.employeeNew

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.camilorubio.robin.R
import com.camilorubio.robin.databinding.EmployeeNewFragmentBinding
import com.camilorubio.robin.utility.viewModel.ViewModelFactory
import com.camilorubio.robin.view.employeeNew.adapter.EmployeeNewAdapter
import com.camilorubio.robin.viewmodel.employeenew.EmployeeNewViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class EmployeeNewFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: EmployeeNewViewModel by viewModels { viewModelFactory }
    private lateinit var binding : EmployeeNewFragmentBinding
    private lateinit var adapter : EmployeeNewAdapter

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.employee_new_fragment, container, false
        )

        binding.lifecycleOwner = this

        setupAdapter()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getEmployeesNew()

        viewModel.employeesNew.observe(viewLifecycleOwner, { listEmployeeBind ->
            adapter.submitList(listEmployeeBind)
        })
    }

    private fun setupAdapter() {
        adapter = EmployeeNewAdapter()
        binding.recyclerViewEmployeeNew.adapter = adapter
    }

}