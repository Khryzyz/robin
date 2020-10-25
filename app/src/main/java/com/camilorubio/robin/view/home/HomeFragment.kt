package com.camilorubio.robin.view.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.camilorubio.robin.R
import com.camilorubio.robin.databinding.HomeFragmentBinding
import com.camilorubio.robin.utils.viewModel.ViewModelFactory
import com.camilorubio.robin.view.home.adapter.BossEmployeeAdapter
import com.camilorubio.robin.view.model.BossEmployeeBind
import com.camilorubio.robin.viewmodel.home.HomeViewModel
import com.camilorubio.robin.viewmodel.UIState
import com.camilorubio.robin.viewmodel.share.ShareViewModel
import dagger.android.support.AndroidSupportInjection
import timber.log.Timber
import javax.inject.Inject

class HomeFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: HomeViewModel by viewModels { viewModelFactory }
    private val shareViewModel : ShareViewModel by activityViewModels { viewModelFactory }
    private lateinit var binding : HomeFragmentBinding
    private lateinit var adapter : BossEmployeeAdapter

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.home_fragment, container, false
        )

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        setupAdapter()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getEmployees()

        viewModel.bossEmployees.observe(viewLifecycleOwner, { uiState ->
            when(uiState) {
                is UIState.Success -> {
                    adapter.submitList(uiState.data as List<BossEmployeeBind>)
                    viewModel.getCompany()?.let { companyBind ->
                        shareViewModel.setCompanyBind(companyBind)
                    }
                }
                is UIState.Error -> Toast.makeText(requireContext(), uiState.message, Toast.LENGTH_SHORT).show()
            }
        })

    }

    private fun setupAdapter() {
        adapter = BossEmployeeAdapter { idBossEmployee ->
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToEmployeeFragment(idBossEmployee)
            )
        }
        binding.recyclerViewBossEmployee.adapter = adapter
    }


}