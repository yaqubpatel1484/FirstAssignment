package com.example.firstassignment.network

import com.example.firstassignment.data.PostData
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    fun getPostData(): Single<ArrayList<PostData>>


}