package com.example.firstassignment.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Inject


object ServiceBuilder  {


        private val URL:String =  "https://patilshreyas.github.io//DummyFoodiumApi/api/"


        private val logger:HttpLoggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)


    private val okHttp:OkHttpClient.Builder = OkHttpClient.Builder()
        .retryOnConnectionFailure(true)
        .callTimeout(15,TimeUnit.SECONDS)
        .connectTimeout(15,TimeUnit.SECONDS)
        .readTimeout(15,TimeUnit.SECONDS)
        .writeTimeout(15,TimeUnit.SECONDS)
        .addInterceptor(logger)

    val gson: Gson = GsonBuilder().setLenient().create()

    private val builder:Retrofit.Builder = Retrofit.Builder().baseUrl(URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(okHttp.build())


    private val retrofit:Retrofit = builder.build();



    fun <T> buildService(serviceType: Class<T>): T {
        return retrofit.create(serviceType)
    }

//    fun  buildService(serviceType: AppHelper) : AppHelper{
//            return retrofit.create(serviceType.javaClass)
//    }




}