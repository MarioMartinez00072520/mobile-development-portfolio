package com.example.laboratorio05.ui.movie

import android.graphics.Movie
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import com.example.laboratorio05.R
import com.example.laboratorio05.data.category2
import com.example.laboratorio05.data.model.MovieModel
import com.example.laboratorio05.data.qualification2
import kotlin.math.log


class NewMovieFragment : Fragment() {

    private val movieViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    private lateinit var nameEditText: EditText
    private lateinit var categoryEditText: EditText
    private lateinit var descriptionEditText: EditText
    private lateinit var qualificationEditText: EditText
    private lateinit var submitButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()

        submitButton.setOnClickListener{
            movieViewModel.addMovies(MovieModel(
                nameEditText.text.toString(),
                categoryEditText.text.toString(),
                descriptionEditText.text.toString(),
                qualificationEditText.text.toString()
            ))
            Log.d("Lista: ", movieViewModel.getMovies().toString())
        }


    }

    fun bind(){
        nameEditText = view?.findViewById(R.id.name_edit_text) as EditText
        categoryEditText = view?.findViewById(R.id.category_edit_text) as EditText
        descriptionEditText = view?.findViewById(R.id.description_edit_text) as EditText
        qualificationEditText = view?.findViewById(R.id.qualification_edit_text) as EditText
        submitButton = view?.findViewById(R.id.submit_button) as Button
    }
}