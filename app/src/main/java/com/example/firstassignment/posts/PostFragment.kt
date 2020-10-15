package com.example.firstassignment.posts

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firstassignment.R
import com.example.firstassignment.data.PostData
import com.example.firstassignment.domain.DaggerPostUsecaseComponent
import com.example.firstassignment.domain.PostUsecase
import com.example.firstassignment.postdetails.PostDetails
import javax.inject.Inject

class PostFragment : Fragment() {

    private lateinit var viewModel: PostViewModel
    private lateinit var adapter: PostAdapter
    private var postList = ArrayList<PostData>()
    private lateinit var recyclerView: RecyclerView

    @Inject
    lateinit var usecase: PostUsecase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.post_fragment, container, false)
        initView(rootView)
        return rootView

    }


    private fun initView(rootView: View) {




     //   val factory = PostViewModelFactory(usecase)
        viewModel = ViewModelProvider(this).get(PostViewModel::class.java)

        recyclerView = rootView.findViewById(R.id.postFragment_recyclerMovieList)
        val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager
        adapter = PostAdapter(context, postList)
        PostAdapter.onItemClickListener = MyListener()
        recyclerView.adapter = adapter


        val result = viewModel.getPost()
        result.observe(viewLifecycleOwner, Observer {
            Log.e("Size","-"+it.size)
            postList.addAll(it)
            adapter.notifyDataSetChanged()
        })

    }


    inner class MyListener : PostAdapter.OnItemClickListener{
        override fun onClick(model: PostData) {
            val fragmentManager: FragmentManager = parentFragmentManager

            val bundle = Bundle()
            bundle.putParcelable("POST", model)

            val details = PostDetails()
            details.arguments = bundle

            fragmentManager.beginTransaction()
                .replace(R.id.baseActivity_baseContainer, details)
                .commit()
        }
    }




}
