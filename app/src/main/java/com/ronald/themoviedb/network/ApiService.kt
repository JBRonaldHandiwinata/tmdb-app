package com.ronald.themoviedb.network

import com.ronald.themoviedb.utils.TMDB_API_KEY
import com.ronald.themoviedb.model.MoviesRecyclerList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @Headers(
        "Content-Type: application/json;charset=utf-8",
        "Authorization: Bearer $TMDB_API_KEY"
    )
    @GET("list/{list_id}")
    fun getPopularMovies(@Path("list_id", encoded = true)listId: Int,
                         @Query("api_key")apiKey:String,
                         @Query("page")page:Int) : Call<MoviesRecyclerList>?

}