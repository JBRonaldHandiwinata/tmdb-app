package com.ronald.themoviedb.ui.detail

import android.app.Application
import android.os.Bundle
import androidx.lifecycle.AndroidViewModel
import com.ronald.themoviedb.model.MovieDetail



class DetailViewModel(application: Application): AndroidViewModel(application) {


    fun getMovieDetail(bundle: Bundle): MovieDetail {
        val data = MovieDetail()
        data.title = bundle.getString("title", "Default");
        data.backdropPath = bundle.getString("backdrop_path", "Default");
        data.overview = bundle.getString("overview", "Default");
        data.posterPath = bundle.getString("poster_path", "Default");
        data.releaseDate = bundle.getString("release_date", "Default");
        data.voteAverage = bundle.getString("vote_average", "Default");
        data.voteCount = bundle.getString("vote_count", "Default");
        return data
    }
}