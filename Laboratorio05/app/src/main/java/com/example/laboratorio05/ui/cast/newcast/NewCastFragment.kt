package com.example.laboratorio05.ui.cast.newcast

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.laboratorio05.databinding.FragmentMovieBinding
import com.example.laboratorio05.databinding.FragmentNewCastBinding
import com.example.laboratorio05.ui.actor.viewmodel.ActorViewModel
import com.example.laboratorio05.ui.cast.viewmodel.CastViewModel
import com.example.laboratorio05.ui.movie.viewmodel.MovieViewModel

class NewCastFragment(): Fragment(){
    private lateinit var binding: FragmentNewCastBinding

    private val movieViewModel: MovieViewModel by viewModels {
        MovieViewModel.Factory
    }

    private val actorViewModel: ActorViewModel by viewModels {
        ActorViewModel.Factory
    }

    private val castViewModel: CastViewModel by viewModels {
        CastViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewCastBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModels()
    }

    private fun setActors

    private fun setViewModels(){
        binding.actorViewModel = actorViewModel
        binding.movieViewModel = movieViewModel
    }
}