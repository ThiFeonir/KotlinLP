package com.example.thial.estudandokotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.aluno_row.view.*

/**
 * Created by Weslley on 21/09/2017.
 */
class AlunoAdapter(val context: Context, val alunoLista: ArrayList<Aluno>) : RecyclerView.Adapter<AlunoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): AlunoAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.aluno_row, parent, false))
    }

    override fun onBindViewHolder(holder: AlunoAdapter.ViewHolder, position: Int) {
        holder.bindItems(alunoLista?.get(position),position)
    }

    override fun getItemCount(): Int {
        return alunoLista.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var nome: String? = null
        var position: Int? = null
        fun bindItems(aluno: Aluno, pos: Int) {
            position = pos + 1
            nome = aluno.nome
            itemView.mTxtAluno.text = aluno.nome
            itemView.mTxtMatricula.text = aluno.matricula
        }

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {

            Toast.makeText(context, "Você clicou em $nome na posição $position", Toast.LENGTH_SHORT).show()
        }
    }
}