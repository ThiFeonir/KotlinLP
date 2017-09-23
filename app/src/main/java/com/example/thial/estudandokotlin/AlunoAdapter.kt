package com.example.thial.estudandokotlin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.aluno_row.view.*

/**
 * Created by Weslley on 21/09/2017.
 */
class AlunoAdapter(val context: Context, val turminha: Turma) : RecyclerView.Adapter<AlunoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): AlunoAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.aluno_row, parent, false))
    }

    override fun onBindViewHolder(holder: AlunoAdapter.ViewHolder, position: Int) {
        holder.bindItems(turminha?.alunos.get(position),position)

    }

    override fun getItemCount(): Int {
        return turminha.alunos.size
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
            itemView.mBtnEdit.setOnClickListener{ itemView -> editItem()}
            itemView.mBtnDelete.setOnClickListener{ itemView -> delelteItem()}
        }

        override fun onClick(v: View?) {

            var bundle = Bundle()
            position?.let { bundle.putInt("pos", it) }
            bundle.putSerializable("turma", turminha)

            val int = Intent(context, ActivityExibirDisciplinas::class.java)
            int.putExtras(bundle)
            context.startActivity(int)

            Toast.makeText(context, "Você clicou em $nome na posição $position", Toast.LENGTH_SHORT).show()
        }

        private fun delelteItem() {
            Toast.makeText(context, "Você clicou em $nome para deletar", Toast.LENGTH_SHORT).show()
        }

        private fun editItem() {
            Toast.makeText(context, "Você clicou em $nome para editar", Toast.LENGTH_SHORT).show()
        }
    }
}