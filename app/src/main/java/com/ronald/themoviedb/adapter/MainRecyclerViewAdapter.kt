package com.ronald.themoviedb.adapter


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ronald.themoviedb.databinding.MovieCardsBinding
import com.ronald.themoviedb.model.MoviesRecyclerData
import com.ronald.themoviedb.ui.detail.DetailActivity



class MainRecyclerViewAdapter: RecyclerView.Adapter<MainRecyclerViewAdapter.MovieViewHolder>() {

    private var listData: List<MoviesRecyclerData>? = null

    fun setUpdateData(listData: List<MoviesRecyclerData>) {
        this.listData = listData
    }

    class MovieViewHolder(val binding: MovieCardsBinding): RecyclerView.ViewHolder(binding.root)
    {
        val movieThumbnail = binding.movieThumbnail
        val faveIcon = binding.faveIcon

        fun bind(data: MoviesRecyclerData?){
            binding.movieData = data

            faveIcon.setOnClickListener{
                data!!.is_fave = true
                val mContext:Context = it.context
                val prefs =  mContext.getSharedPreferences("TMDB", Context.MODE_PRIVATE)
                val prefListData = prefs.getString("faves", "[]")
                val itemType = object : TypeToken<List<MoviesRecyclerData>>() {}.type
                val ld = Gson().fromJson<List<MoviesRecyclerData>>(prefListData, itemType).toMutableList()
                val index:Int = if (ld.size < 1) 0 else ld.size-1
                ld.add(index, data)
                val editor = prefs.edit()
                val lds = Gson().toJson(ld.distinct())
                editor.putString("faves", lds)
                editor.apply()
            }

            movieThumbnail.setOnClickListener {
                val bundle:Bundle = Bundle()
                bundle.putString("title", data?.title)
                bundle.putString("backdrop_path", data?.backdrop_path)
                bundle.putString("overview", data?.overview)
                bundle.putString("poster_path", data?.poster_path)
                bundle.putString("release_date", data?.release_date)
                bundle.putString("vote_average", data?.vote_average.toString())
                bundle.putString("vote_count", data?.vote_count.toString())

                val mContext:Context = it.context
                val intent = Intent(mContext, DetailActivity::class.java)
                intent.putExtra("data", bundle)
                mContext.startActivity(intent)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(MovieCardsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(listData?.get(position))
    }

    override fun getItemCount(): Int {
        if(listData==null) return 0
        else return listData?.size!!
    }
}