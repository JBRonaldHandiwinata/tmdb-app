package com.ronald.themoviedb.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.ronald.themoviedb.Tmdb
import com.ronald.themoviedb.model.MoviesRecyclerData
import com.ronald.themoviedb.utils.TMDB_API_KEY
import com.ronald.themoviedb.model.MoviesRecyclerList
import com.ronald.themoviedb.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList
import javax.inject.Inject


class MainViewModel(application: Application): AndroidViewModel(application) {

    @Inject
    lateinit var api: ApiService

    private var liveDataList: MutableLiveData<MoviesRecyclerList>
    private var topratedDataList: MutableLiveData<MoviesRecyclerList>
    private var faveDataList: MutableList<MoviesRecyclerData>

    init {
        (application as Tmdb).getRetroComponent().inject(this)
        liveDataList = MutableLiveData()
        topratedDataList = MutableLiveData()
        faveDataList = ArrayList()
    }

    fun popularMoviesObserver(): MutableLiveData<MoviesRecyclerList> {
        return liveDataList
    }

    fun getPopularMovies(){
        val call: Call<MoviesRecyclerList>? = api.getPopularMovies(1, TMDB_API_KEY, 1)
        call?.enqueue(object: Callback<MoviesRecyclerList>{
            override fun onFailure(call: Call<MoviesRecyclerList>, t: Throwable) {
                liveDataList.postValue(null)
            }

            override fun onResponse(call: Call<MoviesRecyclerList>, response: Response<MoviesRecyclerList>) {
                if(response.isSuccessful){
                    liveDataList.postValue(response.body())
                }else{
                    liveDataList.postValue(null)
                }
            }

        })
    }

    fun topratedMoviesObserver(): MutableLiveData<MoviesRecyclerList> {
        return topratedDataList
    }

    fun getTopratedMovies() {
        val call: Call<MoviesRecyclerList>? = api.getPopularMovies(2, TMDB_API_KEY, 1)
        call?.enqueue(object : Callback<MoviesRecyclerList> {
            override fun onFailure(call: Call<MoviesRecyclerList>, t: Throwable) {
                topratedDataList.postValue(null)
            }

            override fun onResponse(
                call: Call<MoviesRecyclerList>,
                response: Response<MoviesRecyclerList>
            ) {
                if (response.isSuccessful) {
                    topratedDataList.postValue(response.body())
                } else {
                    topratedDataList.postValue(null)
                }
            }

        })
    }

}