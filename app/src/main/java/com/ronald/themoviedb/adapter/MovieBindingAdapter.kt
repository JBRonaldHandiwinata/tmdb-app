package com.ronald.themoviedb.adapter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ronald.themoviedb.R
import com.ronald.themoviedb.utils.BASE_BACKDROP
import com.ronald.themoviedb.utils.BASE_POSTER
import com.ronald.themoviedb.utils.MOVIE_GENRE


@BindingAdapter("movietitle")
fun getMovieTitle(view: TextView, data: String){
    view.text = if (data.length > 16) data.substring(0,17) else data
}

@BindingAdapter("thumbnail")
fun getThumbnail(view: ImageView, url: String) {
    Glide.with(view)
        .load(BASE_POSTER + url)
        .apply(RequestOptions.centerCropTransform())
        .into(view)
}

@BindingAdapter("genres")
fun getGenre(view: TextView, genres: List<Int>){
    var genre:String? = ""
    genres.forEach {
        genre += MOVIE_GENRE[it] + ", "
    }
    view.text = if (genre!!.length > 26) genre.substring(0, 27) else genre.dropLast(2)
}

@BindingAdapter("loadPoster")
fun moviePoster(view: ImageView, url: String) {
    Glide.with(view)
            .load(BASE_BACKDROP + url)
            .apply(RequestOptions.centerCropTransform())
            .into(view)
}

@BindingAdapter("fave")
fun isFave(view: ImageView, fave: Boolean){
    if(fave){
        view.setImageResource(R.drawable.fave_red)
    }else{
        view.setImageResource(R.drawable.fave_gray)
    }
}

@BindingAdapter("movieRating")
fun getMovieRating(view: TextView, data: String){
    view.text = "$data/10"
}

@BindingAdapter("movieVotes")
fun getMovieVotes(view: TextView, data: String){
    view.text = "$data votes"
}