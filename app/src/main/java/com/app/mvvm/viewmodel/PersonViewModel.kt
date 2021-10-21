package com.app.mvvm.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.app.mvvm.model.PersonModel
import com.app.mvvm.model.PersonModelDao
import com.app.mvvm.model.PersonModelDatabase
import com.app.mvvm.model.PersonModelRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class PersonViewModel(application: Application):AndroidViewModel(application){


    val allPersons: LiveData<List<PersonModel>>
    val repository: PersonModelRepository
    init {
        val dao = PersonModelDatabase.getDatabase(application).getPersonsDao()
        repository = PersonModelRepository(dao)
        allPersons = repository.allPersons
    }

    fun deletePerson(personModel: PersonModel) = viewModelScope.launch(Dispatchers.IO){
        repository.delete(personModel)
    }
    fun updatePerson(personModel: PersonModel) = viewModelScope.launch(Dispatchers.IO){
        repository.update(personModel)
    }
    fun addPerson(personModel: PersonModel) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(personModel)
    }
}