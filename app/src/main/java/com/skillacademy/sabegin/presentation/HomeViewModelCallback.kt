package com.skillacademy.sabegin.presentation

import com.skillacademy.sabegin.data.Result

interface HomeViewModelCallback {

    fun onSuccess(results: List<Result>)
    fun onError(error: Throwable)

}
