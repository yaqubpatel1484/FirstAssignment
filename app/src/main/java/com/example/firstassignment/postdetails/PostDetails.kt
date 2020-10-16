package com.example.firstassignment.postdetails

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide

import com.example.firstassignment.R
import com.example.firstassignment.data.PostData
import kotlinx.android.synthetic.main.fragment_post_details.view.*

class PostDetails : Fragment() {

    private lateinit var model: PostData

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_post_details, container, false)
        initView(rootView)
        return rootView

    }
    private fun initView(rootView: View) {

        arguments?.let {
            model = it.getParcelable("POST")!!

            Glide.with(context!!).load(model.imageUrl).into(rootView.postDetails_ivPoster)
            rootView.postDetails_tvId.text = "${model.id}"
            rootView.postDetails_tvTitle.text = "${model.title}"
            rootView.postDetails_tvAuthor.text = "${model.author}"
            rootView.postDetails_tvBody.text = "${model.body}"

        }


    }

}
