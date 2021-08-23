package com.ronald.themoviedb.ui.main.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.ronald.themoviedb.ui.main.MainViewModel
import com.ronald.themoviedb.adapter.MainRecyclerViewAdapter
import com.ronald.themoviedb.databinding.FragmentMoviesBinding


class PopularFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private lateinit var mainRecyclerViewAdapter: MainRecyclerViewAdapter
    private lateinit var mainViewModel: MainViewModel
    private var _binding : FragmentMoviesBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoviesBinding.inflate(inflater, container, false)
        initRecyclerView()
        initViewModel()
        return binding.root
    }

    private fun initRecyclerView(){
        binding.popularMovieRV.layoutManager = GridLayoutManager(activity, 2)
        mainRecyclerViewAdapter = MainRecyclerViewAdapter()
        binding.popularMovieRV.adapter = mainRecyclerViewAdapter
    }

    private fun initViewModel(){
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.popularMoviesObserver().observe(viewLifecycleOwner,
            { t ->
                if(t != null){
                    mainRecyclerViewAdapter.setUpdateData(t.results)
                    mainRecyclerViewAdapter.notifyDataSetChanged()
                }else{
                    Log.e("Get data ", "error get data")
                }
            })
        mainViewModel.getPopularMovies()
    }

}