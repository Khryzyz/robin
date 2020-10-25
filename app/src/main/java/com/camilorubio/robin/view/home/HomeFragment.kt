package com.camilorubio.robin.view.home

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.camilorubio.robin.R
import com.camilorubio.robin.databinding.HomeFragmentBinding
import com.camilorubio.robin.utility.ActionModeMenu
import com.camilorubio.robin.utility.Utils.Companion.gone
import com.camilorubio.robin.utility.Utils.Companion.visible
import com.camilorubio.robin.utility.viewModel.ViewModelFactory
import com.camilorubio.robin.view.home.adapter.BossEmployeeAdapter
import com.camilorubio.robin.view.model.BossEmployeeBind
import com.camilorubio.robin.viewmodel.home.HomeViewModel
import com.camilorubio.robin.viewmodel.UIState
import com.camilorubio.robin.viewmodel.share.ShareViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class HomeFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: HomeViewModel by viewModels { viewModelFactory }
    private val shareViewModel : ShareViewModel by activityViewModels { viewModelFactory }
    private lateinit var binding : HomeFragmentBinding
    private lateinit var adapter : BossEmployeeAdapter
    private lateinit var actionMode: ActionModeMenu

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)

        binding = DataBindingUtil.inflate(
            inflater, R.layout.home_fragment, container, false
        )

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        setupAdapter()

        setupActionModeMenu()

        setListeners()

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_search, menu)
        super.onCreateOptionsMenu(menu, inflater)
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
        adapter = BossEmployeeAdapter (clickListener =  { idBossEmployee ->
            actionMode.getMode()?.let { actionMode ->
                actionMode.finish()
            }
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToEmployeeFragment(idBossEmployee)
            )
        }, checked = { idBossEmployee, status ->
            viewModel.setStatusCheckByEmployee(idBossEmployee, status)
        })
        binding.recyclerViewBossEmployee.adapter = adapter
        binding.recyclerViewBossEmployee.itemAnimator = null
    }

    private fun setupActionModeMenu() {
        actionMode = ActionModeMenu(clickSelect = {

        }, clickBack =  {
            binding.apply {
                textViewCompanyName.visible()
                textViewCompanyAddress.visible()
                buttonAddNews.visible()
            }
            viewModel.setItemsSelectable(false)
            viewModel.cleanSelection()
        })
    }

    private fun setListeners() {
        binding.buttonAddNews.setOnClickListener {
            binding.apply {
                textViewCompanyName.gone()
                textViewCompanyAddress.gone()
                buttonAddNews.gone()
            }
            if (actionMode.getMode() == null) {
                viewModel.setItemsSelectable(true)
                actionMode.startActionMode(view, R.menu.menu_selection_employee)
            }
        }
    }


}