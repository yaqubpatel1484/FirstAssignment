package com.example.firstassignment.posts

import androidx.lifecycle.ViewModel
import com.example.firstassignment.data.PostData
//import com.example.firstassignment.domain.DaggerPostUsecaseComponent
import com.example.firstassignment.domain.PostUsecase
import dagger.Provides
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject


class PostViewModel @Inject constructor(val usecase: PostUsecase) : ViewModel()  {



    private val compositeDisposable = CompositeDisposable()

   //val usecase = DaggerPostUsecaseComponent.create().getPostUsecase()

    init {

        getPost()
    }

    private val behaviorSubject = BehaviorSubject.create<List<PostData>>()
    fun observePost (): Observable<List<PostData>> = behaviorSubject.observeOn(AndroidSchedulers.mainThread())
    private fun getPost(){

        compositeDisposable.add(usecase.getData1()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                behaviorSubject.onNext(it)
            },{
                behaviorSubject.onError(it)
            })
        )
    }


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}
