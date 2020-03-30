package com.skillacademy.sabegin.presentation

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.skillacademy.sabegin.data.Result

class HomeAdapterViewModel (result: Result):BaseObservable(){

    val title: String = result.title
    @Bindable get

    val overview : String = result.overview
    @Bindable get

}