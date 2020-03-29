package com.skillacademy.sabegin.presentation

import com.skillacademy.sabegin.data.Result

interface HomeView {

    fun showLoading()
    fun hideLoading()
    fun onResponse(results:List<Result>)
    fun onFailure(error: Throwable)
}