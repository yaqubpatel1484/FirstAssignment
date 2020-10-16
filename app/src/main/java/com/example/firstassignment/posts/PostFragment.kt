package com.example.firstassignment.posts

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firstassignment.R
import com.example.firstassignment.data.PostData
import com.example.firstassignment.postdetails.PostDetails
import dagger.android.support.DaggerFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class PostFragment : DaggerFragment() {

   // private lateinit var viewModel: PostViewModel
    private lateinit var adapter: PostAdapter
    private var postList = ArrayList<PostData>()
    private lateinit var recyclerView: RecyclerView

    private val compositeDisposable = CompositeDisposable()

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: PostViewModel by lazy {
        ViewModelProvider(this,viewModelFactory).get(PostViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.post_fragment, container, false)
        initView(rootView)
        return rootView

    }


    private fun initView(rootView: View) {

        recyclerView = rootView.findViewById(R.id.postFragment_recyclerMovieList)
        val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager
        adapter = PostAdapter(context, postList)
        PostAdapter.onItemClickListener = MyListener()
        recyclerView.adapter = adapter

        compositeDisposable.add(
            viewModel.observePost()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    postList.addAll(it)
                    adapter.notifyDataSetChanged()
                }, {
                    Log.e("Error found", "-$it")
                })
        )

    }


    inner class MyListener : PostAdapter.OnItemClickListener {
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


    override fun onDestroyView() {
        super.onDestroyView()
        compositeDisposable.clear()
    }

}
