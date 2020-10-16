package com.example.firstassignment.repository

import com.example.firstassignment.data.PostData
import com.example.firstassignment.data.source.BaseRepo
import com.example.firstassignment.network.ApiService
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers.io
import javax.inject.Inject

    class AppRepo @Inject constructor(val apiService: ApiService):BaseRepo {

        override fun getPosts(): Single<ArrayList<PostData>> {
            return apiService.getPostData().subscribeOn(io())
        }

}