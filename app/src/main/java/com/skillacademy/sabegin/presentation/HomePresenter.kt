package com.skillacademy.sabegin.presentation

import com.skillacademy.sabegin.di.module.NetworkModule
import com.skillacademy.sabegin.data.HomeDatasource
import com.skillacademy.sabegin.data.HomeResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePresenter (private val view: HomeView, private val datasource: HomeDatasource){

    private val disposable: CompositeDisposable = CompositeDisposable()

    fun discoverMovie(){
        view. showLoading()

        datasource.doscoverMovie()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({response ->
                view.hideLoading()
                view.onResponse(response.results)
            },{error ->
                view.hideLoading()
                view.onFailure(error)
            }).addTo(disposable)
    }

    fun onDetach(){
        disposable.clear()
    }
}