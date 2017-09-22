package com.example.thial.estudandokotlin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.aluno_row.view.*
import kotlinx.android.synthetic.main.content_activity_exibir_disciplinas.*

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
            position = pos
            nome = aluno.nome
            itemView.mTxtAluno.text = aluno.nome
            itemView.mTxtMatricula.text = aluno.matricula
        }

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {


            val int = Intent(context, ActivityExibirDisciplinas::class.java)
            int.putExtra("disciplinas", this!!.position?.let { alunoLista.get(it).disciplinas })
            context.startActivity(int)

            /*recyclerViewDisciplina.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = DisciplinaAdapter(context, this!!.position?.let { alunoLista.get(it).disciplinas }!!)*/
            Toast.makeText(context, "Você clicou em $nome na posição $position", Toast.LENGTH_SHORT).show()
        }
    }
}