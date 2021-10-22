package com.app.mvvm.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.mvvm.R
import com.app.mvvm.model.PersonModel
import com.app.mvvm.viewmodel.PersonViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), PersonClickInterface, PersonClickDeleteInterface {

    lateinit var personsRV: RecyclerView
    lateinit var addFAB: FloatingActionButton
    lateinit var viewModel: PersonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        personsRV = findViewById(R.id.idRVPersons)
        addFAB = findViewById(R.id.btSubmit)
        personsRV.layoutManager = LinearLayoutManager(this)

        val personRVAdapter = PersonRVAdapter(this, this, this)
        personsRV.adapter = personRVAdapter
        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(PersonViewModel::class.java)
        viewModel.allPersons.observe(this, Observer { list ->
            list?.let {
                personRVAdapter.updateList(it)
            }
            addFAB.setOnClickListener{
                val intent = Intent(this@MainActivity,NewPersonActivity::class.java)
                startActivity(intent)
                this.finish()
            }
        })


    }

    override fun onPersonClick(personModel: PersonModel) {
        val intent = Intent(this@MainActivity,EditPersonActivity::class.java)
        intent.putExtra("personType","Edit")
        intent.putExtra("personName",personModel.personName)
        intent.putExtra("personApePat",personModel.personApellidoPat)
        intent.putExtra("personApeMat",personModel.personApellidoMat)
        intent.putExtra("personDni",personModel.personDni)
        intent.putExtra("personTemp",personModel.personTemp)
        intent.putExtra("personPeso",personModel.personPeso)
        intent.putExtra("personPres",personModel.personPres)
        intent.putExtra("personSat",personModel.personSat)
        intent.putExtra("personID",personModel.id)
        startActivity(intent)
        this.finish()
    }

    override fun onDeleteIconClick(personModel: PersonModel) {
        TODO("Not yet implemented")
    }
}