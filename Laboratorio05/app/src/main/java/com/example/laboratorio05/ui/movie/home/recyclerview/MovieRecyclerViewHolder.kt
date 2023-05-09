package com.example.laboratorio05.ui.movie.home.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio05.data.model.MovieModel
import com.example.laboratorio05.databinding.MovieItemBinding

class MovieRecyclerViewHolder(private val binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: MovieModel, clickListener: (MovieModel)-> Unit){
        binding.movieItemTitleTextView.text = movie.name
        binding.movieItemCalificationTextView.text = movie.qualification

        binding.movieItemCardView.setOnClickListener{
            clickListener(movie)
        }
    }

}