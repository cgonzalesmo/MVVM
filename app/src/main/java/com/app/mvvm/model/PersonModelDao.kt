package com.app.mvvm.model

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface PersonModelDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(personModel: PersonModel)

    @Update
    suspend fun update(personModel: PersonModel)

    @Delete
    suspend fun delete(personModel: PersonModel)

    @Query("Select * from personasTable")
    fun getAllPersons():LiveData<List<PersonModel>>
}