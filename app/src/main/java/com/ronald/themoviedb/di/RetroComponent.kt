package com.ronald.themoviedb.di

import com.ronald.themoviedb.ui.main.MainViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetroModule::class])
interface RetroComponent {

    fun inject(mainViewModel: MainViewModel)
}