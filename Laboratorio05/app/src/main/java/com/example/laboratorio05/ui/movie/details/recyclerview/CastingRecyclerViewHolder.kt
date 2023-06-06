package com.example.laboratorio05.ui.movie.details.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio05.data.model.ActorModel
import com.example.laboratorio05.data.model.CastModel
import com.example.laboratorio05.data.model.MovieModel
import com.example.laboratorio05.databinding.CastingItemBinding

class CastingRecyclerViewHolder(private val binding: CastingItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(casting: ActorModel){
        binding.castingItemNameTextView.text = casting.name
    }

}