package com.ronald.themoviedb.ui.detail

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.ronald.themoviedb.databinding.ActivityDetailBinding


class DetailActivity: AppCompatActivity() {

    private lateinit var binding : ActivityDetailBinding
    private lateinit var detailViewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle = intent.extras?.getBundle("data")
        if (bundle != null) {
            initViewModel(binding, bundle)
        }
    }

    private fun initViewModel(binding: ActivityDetailBinding, bundle: Bundle){
        detailViewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        binding.movieDetail = detailViewModel.getMovieDetail(bundle)
    }
}