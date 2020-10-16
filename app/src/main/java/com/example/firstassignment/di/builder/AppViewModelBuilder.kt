package com.example.firstassignment.di.builder

import androidx.lifecycle.ViewModel
import com.example.firstassignment.di.qualifier.ViewModelKey
import com.example.firstassignment.posts.PostViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class AppViewModelBuilder {

    @Binds
    @IntoMap
    @ViewModelKey(PostViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: PostViewModel): ViewModel
}