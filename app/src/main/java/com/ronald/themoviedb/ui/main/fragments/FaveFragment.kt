package com.ronald.themoviedb.ui.main.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ronald.themoviedb.adapter.MainRecyclerViewAdapter
import com.ronald.themoviedb.databinding.FragmentFaveBinding
import com.ronald.themoviedb.model.MoviesRecyclerData
import com.ronald.themoviedb.ui.main.MainViewModel


class FaveFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private lateinit var mainViewModel: MainViewModel
    private lateinit var mainRecyclerViewAdapter: MainRecyclerViewAdapter
    private var _binding: FragmentFaveBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFaveBinding.inflate(inflater, container, false)
        initRecyclerView()
        getFaveList()
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        initRecyclerView()
        getFaveList()
    }

    private fun initRecyclerView(){
        binding.popularMovieRV.layoutManager = GridLayoutManager(activity, 2)
        mainRecyclerViewAdapter = MainRecyclerViewAdapter()
        binding.popularMovieRV.adapter = mainRecyclerViewAdapter
    }

    fun getFaveList(){
        val prefs =  requireActivity().getSharedPreferences("TMDB", Context.MODE_PRIVATE)
        val prefListData = prefs.getString("faves", "[]")
        val itemType = object : TypeToken<List<MoviesRecyclerData>>() {}.type
        val ld = Gson().fromJson<List<MoviesRecyclerData>>(prefListData, itemType).toMutableList()
        mainRecyclerViewAdapter.setUpdateData(ld)
        mainRecyclerViewAdapter.notifyDataSetChanged()
    }

}