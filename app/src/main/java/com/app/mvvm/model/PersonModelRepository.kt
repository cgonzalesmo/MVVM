package com.app.mvvm.model

import androidx.lifecycle.LiveData

class PersonModelRepository(private val personModelDao: PersonModelDao) {

    val allPersons: LiveData<List<PersonModel>> = personModelDao.getAllPersons()

    suspend fun insert(personModel: PersonModel){
        personModelDao.insert(personModel)
    }
    suspend fun delete(personModel: PersonModel){
        personModelDao.delete(personModel)
    }
    suspend fun update(personModel: PersonModel){
        personModelDao.update(personModel)
    }

}