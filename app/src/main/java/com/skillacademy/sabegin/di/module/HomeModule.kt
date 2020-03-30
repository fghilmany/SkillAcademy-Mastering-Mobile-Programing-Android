package com.skillacademy.sabegin.di.module

import com.skillacademy.sabegin.data.HomeDatasource
import com.skillacademy.sabegin.presentation.*
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
abstract class HomeModule{

    @Module
    companion object{

        @JvmStatic
        @Provides
        fun providesHomeDatasource(retrofit: Retrofit):HomeDatasource =
            retrofit.create(HomeDatasource::class.java)

        @JvmStatic
        @Provides
        fun providesHomeViewModel(
            callback: HomeViewModelCallback,
            datasource: HomeDatasource
        ):HomeViewModel = HomeViewModel(callback,datasource)

    }

    @Binds
    abstract fun bindHomeViewModelCallback(activity: HomeActivity): HomeViewModelCallback

}