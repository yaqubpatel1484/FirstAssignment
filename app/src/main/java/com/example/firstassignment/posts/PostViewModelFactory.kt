package com.example.firstassignment.posts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.firstassignment.repository.AppRepo

@Suppress("UNCHECKED_CAST")
class PostViewModelFactory (private val appRepo: AppRepo): ViewModelProvider.NewInstanceFactory() {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return PostViewModel(appRepo) as T
        }

}