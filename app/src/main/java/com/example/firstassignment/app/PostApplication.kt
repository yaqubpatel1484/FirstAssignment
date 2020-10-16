package com.example.firstassignment.app

import android.content.Context
import androidx.multidex.MultiDex
import com.example.firstassignment.R
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import uk.co.chrisjenx.calligraphy.CalligraphyConfig
import com.example.firstassignment.di.component.DaggerCoreComponent

class PostApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
       return DaggerCoreComponent
           .builder()
           .application(this)
           .build()

    }

    override fun onCreate() {
        super.onCreate()
        CalligraphyConfig.initDefault(
            CalligraphyConfig.Builder()
            .setDefaultFontPath("fonts/Robboto.TTF")
            .setFontAttrId(R.attr.fontPath)
            .build()
        )
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}