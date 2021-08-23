package com.ronald.themoviedb.model

data class MoviesRecyclerList (val results: List<MoviesRecyclerData>)

data class MoviesRecyclerData(
    val adult: Boolean,
    val backdrop_path: String?,
    val id: Int?,
    val media_type:String?,
    val original_language:String?,
    val genre_ids: List<Int>,
    val original_title:String?,
    val overview:String?,
    val popularity:Float?,
    val poster_path:String?,
    val release_date:String?,
    val title:String?,
    val video:Boolean,
    val vote_average:Float,
    val vote_count:Int?,
    var is_fave:Boolean? = false
)
