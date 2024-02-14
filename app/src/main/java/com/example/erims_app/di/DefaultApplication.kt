package com.example.erims_app.di

import android.app.Application

class DefaultApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container
    }
}