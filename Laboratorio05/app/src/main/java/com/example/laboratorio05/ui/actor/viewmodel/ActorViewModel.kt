package com.example.laboratorio05.ui.actor.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.laboratorio05.MovieReviewerApplication
import com.example.laboratorio05.data.model.ActorModel
import com.example.laboratorio05.repositories.ActorRepository
import kotlinx.coroutines.launch

class ActorViewModel(private val repository: ActorRepository): ViewModel(){
    var name = MutableLiveData("")
    var status = MutableLiveData("")

    suspend fun getActors() = repository.getActors()

    private fun addActor(actor: ActorModel){
        viewModelScope.launch{
            repository.addActor(actor)
        }
    }

    fun createActor(){
        if(!validateData()){
            status.value = WRONG_INFORMATION
            return
        }

        val actor = ActorModel(
            name = name.value!!
        )

        addActor(actor)
        clearData()

        status.value = ACTOR_CREATED
    }

    private fun clearData() {
        name.value = ""
    }

    fun clearStatus(){
        status.value = INACTIVE
    }

    private fun validateData(): Boolean {
        when{
            name.value.isNullOrEmpty() -> return false
        }
        return true
    }

    companion object{
        val Factory =  viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as MovieReviewerApplication
                ActorViewModel(app.actorRepository)
            }
        }

        const val ACTOR_CREATED = "Actor Created"
        const val WRONG_INFORMATION = "Wrong Information"
        const val INACTIVE = ""
    }
}