package com.app.mvvm.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "personasTable")
class PersonModel(
    @ColumnInfo(name = "nombre") val personName:String,
    @ColumnInfo(name = "apellidoPaterno") val personApellidoPat:String,
    @ColumnInfo(name = "apellidoMaterno") val personApellidoMat:String,
    @ColumnInfo(name = "dni") val personDni:String,
    @ColumnInfo(name = "temperatura") val personTemp:Double,
    @ColumnInfo(name = "peso") val personPeso:Double,
    @ColumnInfo(name = "presion") val personPres:Double,
    @ColumnInfo(name = "saturacion") val personSat:Double,
) {
    @PrimaryKey(autoGenerate = true)
    var id=0
}