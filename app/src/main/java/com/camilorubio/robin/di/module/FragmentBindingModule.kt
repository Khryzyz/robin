package com.camilorubio.robin.di.module

import com.camilorubio.robin.view.employee.EmployeeFragment
import com.camilorubio.robin.view.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {

    @ContributesAndroidInjector
    abstract fun bindHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun bindEmployeeFragment(): EmployeeFragment

}