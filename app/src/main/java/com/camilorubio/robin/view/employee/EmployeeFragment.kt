package com.camilorubio.robin.view.employee

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.camilorubio.robin.R
import com.camilorubio.robin.databinding.EmployeeFragmentBinding
import com.camilorubio.robin.utils.viewModel.ViewModelFactory
import com.camilorubio.robin.view.employee.adapter.EmployeeAdapter
import com.camilorubio.robin.viewmodel.employee.EmployeeViewModel
import com.camilorubio.robin.viewmodel.share.ShareViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class EmployeeFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: EmployeeViewModel by viewModels { viewModelFactory }
    private val shareViewModel : ShareViewModel by activityViewModels { viewModelFactory }
    private lateinit var binding : EmployeeFragmentBinding
    private val args : EmployeeFragmentArgs by navArgs()
    private lateinit var adapter : EmployeeAdapter

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.employee_fragment, container, false
        )

        binding.lifecycleOwner = this

        setupAdapter()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        shareViewModel.getBossEmployeeById(args.idBossEmployee) { bossEmployeeBind ->
            bossEmployeeBind?.let { bossEmployeeBind ->
                viewModel.setInformationBossEmployee(bossEmployeeBind)
            }
        }

        viewModel.employees.observe(viewLifecycleOwner, { listEmployees ->
            listEmployees?.let { listEmployeesBind ->
                adapter.submitList(listEmployeesBind)
            }
        })
    }

    private fun setupAdapter() {
        adapter = EmployeeAdapter()
        binding.recyclerViewEmployee.adapter = adapter
    }

}