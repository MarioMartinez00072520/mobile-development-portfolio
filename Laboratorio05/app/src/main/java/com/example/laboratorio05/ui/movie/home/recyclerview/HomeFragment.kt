package com.example.laboratorio05.ui.movie.home.recyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.cardview.widget.CardView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.laboratorio05.R
import com.example.laboratorio05.data.model.MovieModel
import com.example.laboratorio05.databinding.FragmentHomeBinding
import com.example.laboratorio05.ui.movie.viewmodel.MovieViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private lateinit var adapter: MovieRecyclerViewAdapter
    private lateinit var binding: FragmentHomeBinding

    private val movieViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch{
            setRecyclerView(view)
        }

        binding.homeAddMovieFab.setOnClickListener {
            movieViewModel.clearData()
            it.findNavController().navigate(R.id.action_homeFragment_to_newMovieFragment)
        }
        binding.homeAddActorFab.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_newActorFragment)
        }
        binding.homeAddCastingFab.setOnClickListener{
            it.findNavController().navigate(R.id.action_homeFragment_to_newCastFragment)
        }
    }

    private fun showSelectedItem(movie: MovieModel){
        movieViewModel.setSelectedMovie(movie)
        findNavController().navigate(R.id.action_homeFragment_to_movieFragment)
    }

    private suspend fun displayMovies(){
        adapter.setData(movieViewModel.getMovies())
        adapter.notifyDataSetChanged()
    }

    private suspend fun setRecyclerView(view: View) {
        binding.movieRecyclerView.layoutManager = LinearLayoutManager(view.context)
        adapter = MovieRecyclerViewAdapter { selectedMovie ->
            showSelectedItem(selectedMovie)
        }
        binding.movieRecyclerView.adapter = adapter
        displayMovies()
    }
}