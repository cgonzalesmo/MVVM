package com.app.mvvm.view

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.app.mvvm.R
import com.app.mvvm.model.PersonModel
import com.app.mvvm.viewmodel.PersonViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText

class EditPersonActivity : AppCompatActivity() {


    lateinit var personNameTv : TextView
    lateinit var personApeTv : TextView
    lateinit var personDniTv : TextView

    lateinit var personTempEdt : TextInputEditText
    lateinit var personPesoEdt : TextInputEditText
    lateinit var personPresEdt : TextInputEditText
    lateinit var personSatEdt : TextInputEditText

    lateinit var addbtn: FloatingActionButton

    lateinit var viewModel: PersonViewModel
    var personID = -1;



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_person)

        personNameTv = findViewById(R.id.ed_patient_name)
        personApeTv = findViewById(R.id.ed_patient_ape)
        personDniTv = findViewById(R.id.ed_patient_dni)


        personTempEdt = findViewById(R.id.ep_tit_temp)
        personPesoEdt = findViewById(R.id.ep_tit_peso)
        personPresEdt = findViewById(R.id.ep_tit_pres)
        personSatEdt = findViewById(R.id.ep_tit_sat)


        addbtn = findViewById(R.id.np_fab_save)
        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(PersonViewModel::class.java)

        personID = intent.getIntExtra("personID", -1)
        val personName = intent.getStringExtra("personName")
        val personApePat = intent.getStringExtra("personApePat")
        val personApeMat = intent.getStringExtra("personApeMat")
        val apellidos = personApePat  +" "+ personApeMat
        val personDni = intent.getStringExtra("personDni")
        val personTemp = intent.getDoubleExtra("personTemp",0.0)
        val personPeso = intent.getDoubleExtra("personPeso",0.0)
        val personPres = intent.getDoubleExtra("personPres",0.0)
        val personSat = intent.getDoubleExtra("personSat",0.0)


        personNameTv.setText(personName)
        personApeTv.setText(apellidos)
        personDniTv.setText(personDni)
        personTempEdt.setText(personTemp.toString())
        personPesoEdt.setText(personPeso.toString())
        personPresEdt.setText(personPres.toString())
        personSatEdt.setText(personSat.toString())


        addbtn.setOnClickListener{
            val Name = personNameTv.text.toString()
            val ApePat = intent.getStringExtra("personApePat").toString()
            val ApeMat = intent.getStringExtra("personApeMat").toString()
            val Dni = personDniTv.text.toString()
            val Temp = personTempEdt.text.toString().toDouble()
            val Peso = personPesoEdt.text.toString().toDouble()
            val Pres = personPresEdt.text.toString().toDouble()
            val Sat = personSatEdt.text.toString().toDouble()

            val updatePerson = PersonModel(Name,ApePat,ApeMat,Dni,Temp,Peso,Pres,Sat)
            updatePerson.id=personID
            viewModel.updatePerson(updatePerson)
            Toast.makeText(this, "Person update", Toast.LENGTH_LONG).show()

            startActivity(Intent(applicationContext,MainActivity::class.java))
            this.finish()

        }


    }

}