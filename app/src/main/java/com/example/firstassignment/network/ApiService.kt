package com.example.firstassignment.network

import com.example.firstassignment.data.PostData
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit
import javax.inject.Inject


interface ApiService {


    @GET("posts")
    fun getMovieData(): Call<ArrayList<PostData>>



//    companion object {
//
//
//        operator fun invoke(): ApiService {
//            val URL = "https://patilshreyas.github.io//DummyFoodiumApi/api/"
//
//            val logger: HttpLoggingInterceptor =
//                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
//
//            val okHttp: OkHttpClient.Builder = OkHttpClient.Builder()
//                .retryOnConnectionFailure(true)
//                .callTimeout(5, TimeUnit.SECONDS)
//                .connectTimeout(5, TimeUnit.SECONDS)
//                .addInterceptor(logger)
//
//            val gson: Gson = GsonBuilder().setLenient().create()
//            return Retrofit.Builder()
//                .baseUrl(URL)
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .client(okHttp.build())
//                .build()
//                .create(ApiService::class.java)
//        }
//    }


}