package com.example.firstassignment.di.builder

import com.example.firstassignment.data.source.BaseRepo
import com.example.firstassignment.repository.AppRepo
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryBuilder {
    @Binds
    abstract fun bindsMovieRepository(repoImp: AppRepo): BaseRepo
}