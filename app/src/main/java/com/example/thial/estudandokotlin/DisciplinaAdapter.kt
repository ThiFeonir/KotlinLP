package com.example.thial.estudandokotlin

import android.content.Context
import android.graphics.Color
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
        holder.bindItens(disciplinaLista?.get(position),position)
    }

    override fun getItemCount(): Int {
       return disciplinaLista.size
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),View.OnClickListener {
        var matricula : String? = null
        var position : Int? = null
        fun bindItens(disciplina : Disciplina, pos : Int) {
            position = pos
            matricula = disciplina.nome
            itemView.mTxtDisciplina.text = disciplina.nome
            itemView.mTxtNotaUm.text = disciplina.nota1.toString()
            itemView.mTxtNotaDois.text = disciplina.nota2.toString()
            itemView.mTxtNotaTres.text = disciplina.nota3.toString()

            var media: Double = ((disciplina.nota1 !!+ disciplina.nota2!! + disciplina.nota3!!)/3)
            itemView.mTxtMedia.text = media.toString()
            if (media >= 5){
                itemView.mTxtSituacao.text = "Aprovado"
                itemView.mTxtSituacao.setTextColor(Color.GREEN)
            } else {
                itemView.mTxtSituacao.text = "Reprovado"
                itemView.mTxtSituacao.setTextColor(Color.RED)
            }
        }

        init {
            itemView.setOnClickListener(this)
            itemView.mImgBtnEdit.setOnClickListener { editItem() }
            itemView.mImgBtnDelete.setOnClickListener { deleteItem() }
        }

        override fun onClick(v: View?) {
            Toast.makeText(context, "Você clicou na posição $position", Toast.LENGTH_SHORT).show()
        }

        private fun deleteItem() {
            Toast.makeText(context, "Você clicou em $matricula para deletar", Toast.LENGTH_SHORT).show()
        }

        private fun editItem() {
            Toast.makeText(context, "Você clicou em $matricula para editar", Toast.LENGTH_SHORT).show()
        }
    }
}