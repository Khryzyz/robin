package com.camilorubio.robin.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.camilorubio.robin.utils.viewModel.ViewModelFactory
import com.camilorubio.robin.utils.viewModel.ViewModelKey
import com.camilorubio.robin.viewmodel.employee.EmployeeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(EmployeeViewModel::class)
    internal abstract fun bindEmployeeViewModel(viewModel: EmployeeViewModel): ViewModel

}