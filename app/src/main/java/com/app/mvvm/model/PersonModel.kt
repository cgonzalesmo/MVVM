package com.app.mvvm.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "personasTable")
class PersonModel(
    @ColumnInfo(name = "nombre") val personName:String,
    @ColumnInfo(name = "apellido") val personApellido:String,
) {
    @PrimaryKey(autoGenerate = true)
    var id=0
}