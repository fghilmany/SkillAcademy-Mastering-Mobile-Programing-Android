package com.skillacademy.sabegin.di.builder

import com.skillacademy.sabegin.di.module.HomeModule
import com.skillacademy.sabegin.di.scope.Presentation
import com.skillacademy.sabegin.presentation.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @Presentation
    @ContributesAndroidInjector(modules = [HomeModule::class])
    abstract fun contributeHomeActivity():HomeActivity
}