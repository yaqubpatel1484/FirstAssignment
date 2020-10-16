package com.example.firstassignment.di.component

import android.app.Application
import com.example.firstassignment.app.PostApplication
import com.example.firstassignment.di.builder.ActivityBuilder
import com.example.firstassignment.di.module.ContextModule
import com.example.firstassignment.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class,NetworkModule::class,ActivityBuilder::class, ContextModule::class])
interface CoreComponent: AndroidInjector<PostApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): CoreComponent
    }
}