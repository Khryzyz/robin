package com.camilorubio.robin.view.employee

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.camilorubio.robin.R
import com.camilorubio.robin.databinding.EmployeeFragmentBinding
import com.camilorubio.robin.utils.viewModel.ViewModelFactory
import com.camilorubio.robin.viewmodel.employee.EmployeeViewModel
import com.camilorubio.robin.viewmodel.employee.UIState
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class EmployeeFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: EmployeeViewModel by viewModels { viewModelFactory }
    private lateinit var binding : EmployeeFragmentBinding

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.employee_fragment, container, false
        )

        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getEmployees()

        viewModel.employees.observe(viewLifecycleOwner, Observer { uiState ->
            when(uiState) {
                is UIState.Success -> {}
                is UIState.Error -> Toast.makeText(requireContext(), uiState.message, Toast.LENGTH_SHORT).show()
            }
        })

    }


}