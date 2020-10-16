package com.example.firstassignment.data.source

import com.example.firstassignment.data.PostData
import io.reactivex.Single

interface BaseRepo {

    fun getPosts():Single<ArrayList<PostData>>
}