package com.example.laboratorio05.ui.movie.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.laboratorio05.R
import com.example.laboratorio05.data.model.CastModel
import com.example.laboratorio05.data.model.MovieModel
import com.example.laboratorio05.databinding.FragmentHomeBinding
import com.example.laboratorio05.databinding.FragmentMovieBinding
import com.example.laboratorio05.ui.movie.details.recyclerview.CastingRecyclerViewAdapter
import com.example.laboratorio05.ui.movie.home.recyclerview.MovieRecyclerViewAdapter
import com.example.laboratorio05.ui.movie.viewmodel.MovieViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


class MovieFragment : Fragment() {

    private val movieViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    private lateinit var adapter: CastingRecyclerViewAdapter
    private lateinit var binding: FragmentMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            setRecyclerView(view)
        }
        setViewModel()
    }

    private suspend fun displayCast(){
        val movieId = movieViewModel.id
        CoroutineScope(lifecycleScope.coroutineContext).launch {
            val movieWithActor = movieViewModel.getMovieWithActorById(movieId.value!!)

            val actors = movieWithActor.actors
            adapter.setData(actors!!)

            adapter.notifyDataSetChanged()
        }
    }
    private suspend fun setRecyclerView(view: View) {
        binding.movieCastingRecyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = CastingRecyclerViewAdapter()

        binding.movieCastingRecyclerView.adapter = adapter
        displayCast()
    }
    private fun setViewModel(){
        binding.viewmodel = movieViewModel
    }
}