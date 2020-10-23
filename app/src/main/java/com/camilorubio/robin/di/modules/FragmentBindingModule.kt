package com.camilorubio.robin.di.modules

import com.camilorubio.robin.view.employee.EmployeeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {

    @ContributesAndroidInjector
    abstract fun bindEmployeeFragment(): EmployeeFragment

}