package com.skillacademy.sabegin.di.module

import com.skillacademy.sabegin.data.HomeDatasource
import com.skillacademy.sabegin.presentation.HomeActivity
import com.skillacademy.sabegin.presentation.HomePresenter
import com.skillacademy.sabegin.presentation.HomeView
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
abstract class HomeModule {

    @Module
    companion object{

        @JvmStatic
        @Provides
        fun providesHomeDatasource(retrofit: Retrofit):HomeDatasource =
            retrofit.create(HomeDatasource::class.java)

        @JvmStatic
        @Provides
        fun providesHomePresenter(
            view:HomeView,
            datasource: HomeDatasource
        ): HomePresenter = HomePresenter(view, datasource)
    }

    @Binds
    abstract fun bindMovieView(activity: HomeActivity): HomeView
}