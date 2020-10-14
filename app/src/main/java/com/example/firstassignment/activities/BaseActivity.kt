package com.example.firstassignment.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firstassignment.R
import com.example.firstassignment.posts.PostFragment

class BaseActivity : AppCompatActivity() {

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
