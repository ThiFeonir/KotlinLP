package com.example.thial.estudandokotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.alunos_linhas.view.*

/**
 * Created by Weslley on 21/09/2017.
 */
class AlunoAdapter(val context: Context, val alunoLista: ArrayList<Aluno>) : RecyclerView.Adapter<AlunoAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): AlunoAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.alunos_linhas,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlunoAdapter.ViewHolder, position: Int) {
        holder.bindItems(alunoLista?.get(position))
    }

    override fun getItemCount(): Int {
        return alunoLista.size
    }

   inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(aluno: Aluno) {
            itemView.mTxtAluno.text = aluno.nome
            itemView.mTxtMatricula.text = aluno.matricula
        }
    }

}