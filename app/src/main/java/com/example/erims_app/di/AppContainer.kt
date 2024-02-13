package com.example.erims_app.di

import android.content.Context

interface AppContainer {
}

class AppDataContainer(private val context: Context) : AppContainer {

}