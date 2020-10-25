package com.camilorubio.robin.di.component

import android.app.Application
import com.camilorubio.robin.app.RobinApplication
import com.camilorubio.robin.di.modules.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class, ApplicationModule::class, ActivityBindingModule::class,
        FragmentBindingModule::class, ViewModelModule::class, UseCasesModule::class, RepositoryModule::class,
        RemoteDataSourceModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<RobinApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun create(application: Application): Builder

        fun build(): ApplicationComponent
    }

}