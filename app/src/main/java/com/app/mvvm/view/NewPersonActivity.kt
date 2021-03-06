package com.app.mvvm.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.app.mvvm.R
import com.app.mvvm.model.PersonModel
import com.app.mvvm.viewmodel.PersonViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText

class NewPersonActivity : AppCompatActivity() {

    lateinit var personNameEdT: TextInputEditText
    lateinit var personApePatEdt: TextInputEditText
    lateinit var personApeMatEdt: TextInputEditText
    lateinit var personDniEdt: TextInputEditText


    lateinit var addbtn: FloatingActionButton
    lateinit var viewModel:PersonViewModel
    var personID = -1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_person)
        personNameEdT = findViewById(R.id.np_tit_name)
        personApePatEdt = findViewById(R.id.np_tit_apePat)
        personApeMatEdt = findViewById(R.id.np_tit_apeMat)
        personDniEdt = findViewById(R.id.np_tit_dni)

        addbtn = findViewById(R.id.np_fab_save)
        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(PersonViewModel::class.java)

        val personType = intent.getStringExtra("personType")
        if(personType.equals("Edit")){
            val personName = intent.getStringExtra("personName")
            personID = intent.getIntExtra("personID", -1)
            personNameEdT.setText(personName)

        }else{
            val personName = intent.getStringExtra("personName")
            personID = intent.getIntExtra("personID", -1)
            personNameEdT.setText(personName)

        }
        addbtn.setOnClickListener{
            val personName = personNameEdT.text.toString()
            val personApePat = personApePatEdt.text.toString()
            val personApeMat = personApeMatEdt.text.toString()
            val personDni = personDniEdt.text.toString()

            if(personType.equals("Edit")){
                //Para editar
            }
            else{
                viewModel.addPerson(PersonModel(personName,personApePat,personApeMat,personDni,0.0,0.0,0.0,0.0))
                Toast.makeText(this, "Person add", Toast.LENGTH_LONG).show()
            }
            startActivity(Intent(applicationContext,MainActivity::class.java))
            this.finish()

        }
    }
}