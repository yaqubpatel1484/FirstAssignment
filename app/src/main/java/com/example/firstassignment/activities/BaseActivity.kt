package com.example.firstassignment.activities

import android.os.Bundle
import com.example.firstassignment.R
import com.example.firstassignment.posts.PostFragment
import dagger.android.support.DaggerAppCompatActivity

class BaseActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.base_activity)
        createLauncherFragment()
    }


    private fun createLauncherFragment() {


        supportFragmentManager
            .beginTransaction()
            .add(R.id.baseActivity_baseContainer, PostFragment())
            .commit()

    }
}
