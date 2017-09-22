package com.example.thial.estudandokotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.disciplina_row.view.*
/**
 * Created by Weslley on 22/09/2017.
 */
class DisciplinaAdapter(val context: Context, val disciplinaLista: ArrayList<Disciplina>) : RecyclerView.Adapter<DisciplinaAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): DisciplinaAdapter.ViewHolder{
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.disciplina_row,parent,false))
    }

    override fun onBindViewHolder(holder: DisciplinaAdapter.ViewHolder, position: Int) {
        holder.bindItens(disciplinaLista?.get(position))
    }

    override fun getItemCount(): Int {
       return disciplinaLista.size
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),View.OnClickListener {
        var matricula : String? = null
        fun bindItens(disciplina : Disciplina) {
            matricula = disciplina.nome
            itemView.mTxtDisciplina.text = disciplina.nome
            itemView.mTxtNotaUm.text = disciplina.nota1.toString()
            itemView.mTxtNotaDois.text = disciplina.nota2.toString()
            itemView.mTxtNotaTres.text = disciplina.nota3.toString()
        }

        override fun onClick(v: View?) {
            Toast.makeText(context, "Você clicou em $matricula", Toast.LENGTH_SHORT).show()
        }

    }
}