package com.example.firstassignment.domain

import androidx.lifecycle.LiveData
import com.example.firstassignment.data.PostData
import com.example.firstassignment.repository.AppRepo
import javax.inject.Inject

class PostUsecase @Inject constructor(private val appRepo: AppRepo) {

    fun getData(): LiveData<ArrayList<PostData>> {
        return appRepo.getAllPosts()
    }


}