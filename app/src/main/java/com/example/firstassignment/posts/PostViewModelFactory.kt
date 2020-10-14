package com.example.firstassignment.posts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.firstassignment.domain.PostUsecase
import com.example.firstassignment.repository.AppRepo

@Suppress("UNCHECKED_CAST")
class PostViewModelFactory (private val usecase: PostUsecase): ViewModelProvider.NewInstanceFactory() {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return PostViewModel(usecase) as T
        }

}