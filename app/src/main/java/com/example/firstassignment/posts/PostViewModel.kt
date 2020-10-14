package com.example.firstassignment.posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.firstassignment.data.PostData
import com.example.firstassignment.repository.AppRepo

class PostViewModel(private val appRepo: AppRepo) : ViewModel() {

    fun getPost():LiveData<ArrayList<PostData>>{

      return  appRepo.getAllPosts()

    }

}
