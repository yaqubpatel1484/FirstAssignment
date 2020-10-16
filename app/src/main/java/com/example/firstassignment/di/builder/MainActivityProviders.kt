package com.example.firstassignment.di.builder

import com.example.firstassignment.posts.PostFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityProviders {
    @ContributesAndroidInjector
    abstract fun providePostFragment(): PostFragment

}