package com.example.firstassignment.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.firstassignment.data.PostData
import com.example.firstassignment.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AppRepo(private val apiService: ApiService) {


    fun getAllPosts(): LiveData<ArrayList<PostData>> {

        val responseData = MutableLiveData<ArrayList<PostData>>()

        val request = apiService.getMovieData()
        request.enqueue(object: Callback<ArrayList<PostData>>{
            override fun onResponse(
                call: Call<ArrayList<PostData>>,
                response: Response<ArrayList<PostData>>
            ) {
               if(response.isSuccessful){
                   responseData.value = response.body()
               }
            }

            override fun onFailure(call: Call<ArrayList<PostData>>, t: Throwable) {
               Log.e("Error",t.toString())
            }

        })


        return responseData

    }


}