package com.example.laboratorio05

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeFragment : Fragment() {

    private lateinit var starWarsCardView: CardView
    private lateinit var harryPotterCardView: CardView
    private lateinit var addMovieFloatingActionButton: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        starWarsCardView.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_movieFragment)
        }
        harryPotterCardView.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_movieFragment)
        }
        addMovieFloatingActionButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_newMovieFragment)
        }
    }

    private fun bind(){
        starWarsCardView = view?.findViewById(R.id.star_wars_card_view) as CardView
        harryPotterCardView = view?.findViewById(R.id.harry_potter_card_view) as CardView
        addMovieFloatingActionButton = view?.findViewById(R.id.floatingActionButton) as FloatingActionButton
    }
}