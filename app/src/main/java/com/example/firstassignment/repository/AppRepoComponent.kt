package com.example.firstassignment.repository

import com.example.firstassignment.network.ApiService
import com.example.firstassignment.network.ServiceBuilder
import dagger.Component
import dagger.Module

@Component //(modules = [ServiceBuilder::class])
interface AppRepoComponent {

    fun getRepo() :AppRepo

}