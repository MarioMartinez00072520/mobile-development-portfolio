package com.example.laboratorio05.ui.movie.details.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio05.data.model.ActorModel
import com.example.laboratorio05.data.model.CastModel
import com.example.laboratorio05.data.model.MovieModel
import com.example.laboratorio05.databinding.CastingItemBinding
import com.example.laboratorio05.databinding.MovieItemBinding
import com.example.laboratorio05.ui.movie.home.recyclerview.MovieRecyclerViewHolder

class CastingRecyclerViewAdapter: RecyclerView.Adapter<CastingRecyclerViewHolder>() {
    private val casts = ArrayList<ActorModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastingRecyclerViewHolder {
        val binding =  CastingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CastingRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return casts.size
    }

    override fun onBindViewHolder(holder: CastingRecyclerViewHolder, position: Int) {
        val casting = casts[position]
        holder.bind(casting)
    }

    fun setData(castingList: List<ActorModel>){
        casts.clear()
        casts.addAll(castingList)
    }
}