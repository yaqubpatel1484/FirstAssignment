package com.example.firstassignment.di.builder

import androidx.lifecycle.ViewModelProvider
import com.example.firstassignment.posts.PostViewModelFactory
import dagger.Binds
import dagger.Module

@Module(includes = [
    (RepositoryBuilder::class),
    (AppViewModelBuilder::class)
])
abstract class ViewModelBuilder {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: PostViewModelFactory): ViewModelProvider.Factory
}


