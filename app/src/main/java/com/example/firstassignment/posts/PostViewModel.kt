package com.example.firstassignment.posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.firstassignment.data.PostData
import com.example.firstassignment.domain.PostUsecase
import javax.inject.Inject

class PostViewModel @Inject constructor(private val usecase: PostUsecase) : ViewModel() {

    fun getPost():LiveData<ArrayList<PostData>>{

      return  usecase.getData()

    }

}
