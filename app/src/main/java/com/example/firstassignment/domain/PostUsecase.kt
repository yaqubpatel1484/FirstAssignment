package com.example.firstassignment.domain

import com.example.firstassignment.data.PostData
import com.example.firstassignment.repository.AppRepo
import io.reactivex.Single
import javax.inject.Inject

class PostUsecase @Inject constructor(private val appRepo: AppRepo) {

    fun getData1(): Single<ArrayList<PostData>> {
        return appRepo.getPosts()
    }


}