package com.camilorubio.robin.di.component

import android.app.Application
import com.camilorubio.robin.app.RobinApplication
import com.camilorubio.robin.di.modules.ActivityBindingModule
import com.camilorubio.robin.di.modules.ApplicationModule
import com.camilorubio.robin.di.modules.FragmentBindingModule
import com.camilorubio.robin.di.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, ApplicationModule::class,
    ActivityBindingModule::class, FragmentBindingModule::class, ViewModelModule::class])
interface ApplicationComponent : AndroidInjector<RobinApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun create(application : Application) : Builder

        fun build() : ApplicationComponent

    }

}