package com.skillacademy.sabegin


import com.skillacademy.sabegin.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class BelajarApp: DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.create().apply{ inject(this@BelajarApp)}
    }
}