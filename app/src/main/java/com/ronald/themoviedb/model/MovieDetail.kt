package com.ronald.themoviedb.model


class MovieDetail {
    var title: String? = ""
        get() = field
        set(value){
            field = value
        }

    var backdropPath: String? = ""
        get() = field
        set(value){
            field = value
        }

    var overview: String? = ""
        get() = field
        set(value){
            field = value
        }

    var posterPath: String? = ""
        get() = field
        set(value){
            field = value
        }

    var releaseDate: String? = ""
        get() = field
        set(value){
            field = value
        }

    var voteAverage: String? = ""
        get() = field
        set(value){
            field = value
        }

    var voteCount: String? = ""
        get() = field
        set(value){
            field = value
        }
}

//
//val c = MovieDetail()
//data class MovieInfo (
//        val title:String? = c.title,
//        val backdrop_path:String? = c.backdrop_path
////        val overview:String?,
////        val poster_path:String?,
////        val release_date:String?,
////        val vote_average:String,
////        val vote_count:String?
//)