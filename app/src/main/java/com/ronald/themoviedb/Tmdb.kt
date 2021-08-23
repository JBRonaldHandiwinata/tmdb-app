package com.ronald.themoviedb

import android.app.Application
import com.ronald.themoviedb.di.DaggerRetroComponent
import com.ronald.themoviedb.di.RetroComponent
import com.ronald.themoviedb.di.RetroModule

class Tmdb: Application() {

    private lateinit var retroComponent: RetroComponent

    override fun onCreate() {
        super.onCreate()
        retroComponent = DaggerRetroComponent.builder().retroModule(RetroModule()).build()
    }

    fun getRetroComponent(): RetroComponent {
        return retroComponent
    }
}