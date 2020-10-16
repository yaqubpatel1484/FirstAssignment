package com.example.firstassignment.di.builder

import com.example.firstassignment.activities.BaseActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [MainActivityProviders::class])
    abstract fun bindMainActivity(): BaseActivity
//    @ContributesAndroidInjector()
//    abstract fun bindDetailActivity(): DetailActivity
}