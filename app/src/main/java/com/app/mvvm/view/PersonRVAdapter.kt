package com.app.mvvm.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.app.mvvm.R
import com.app.mvvm.model.PersonModel
import org.w3c.dom.Text

class PersonRVAdapter(
    val context: Context,
    val personClickInterface: PersonClickInterface,
    val personClickDeleteInterface: PersonClickDeleteInterface
    ): RecyclerView.Adapter<PersonRVAdapter.ViewHolder>(){

    private val allPersons = ArrayList<PersonModel>()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val nameTV = itemView.findViewById<TextView>(R.id.patient_name)
        val dniTV = itemView.findViewById<TextView>(R.id.patient_desc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.person_rv_item,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nameTV.setText(allPersons.get(position).personName)
        holder.dniTV.setText(allPersons.get(position).personDni)
        //Añadir los demas espacios
        holder.itemView.setOnClickListener{
            personClickInterface.onPersonClick(allPersons.get(position))
        }
    }

    override fun getItemCount(): Int {
        return allPersons.size
    }
    fun updateList(newList: List<PersonModel>){
        allPersons.clear()
        allPersons.addAll(newList)
        notifyDataSetChanged()
    }
}

interface PersonClickInterface{
    fun onPersonClick(personModel:PersonModel)
}
interface PersonClickDeleteInterface{
    fun onDeleteIconClick(personModel: PersonModel)
}
