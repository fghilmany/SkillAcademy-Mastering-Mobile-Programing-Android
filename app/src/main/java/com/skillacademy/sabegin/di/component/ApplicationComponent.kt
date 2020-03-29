package com.skillacademy.sabegin.di.component

import com.skillacademy.sabegin.BelajarApp
import com.skillacademy.sabegin.di.builder.ActivityBuilder
import com.skillacademy.sabegin.di.module.NetworkModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules =[
    AndroidSupportInjectionModule::class,
    NetworkModule::class,
    ActivityBuilder::class
    ]
)
interface ApplicationComponent : AndroidInjector<BelajarApp>