package com.example.thial.estudandokotlin

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.disciplina_row.view.*
import java.io.IOException
import java.io.ObjectInputStream

/**
 * Created by Weslley on 22/09/2017.
 */
class DisciplinaAdapter(val context: Context, val disciplinaLista: ArrayList<Disciplina>, var posaluno : Int) : RecyclerView.Adapter<DisciplinaAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): DisciplinaAdapter.ViewHolder{
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.disciplina_row,parent,false))
    }

    override fun onBindViewHolder(holder: DisciplinaAdapter.ViewHolder, position: Int) {
        holder.bindItens(disciplinaLista?.get(position),position)
    }

    override fun getItemCount(): Int {
       return disciplinaLista.size
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
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
            itemView.mImgBtnEdit.setOnClickListener { editItem() }
            itemView.mImgBtnDelete.setOnClickListener { deleteItem() }
        }

        private fun deleteItem() {
            val turminha: Turma = abrirArquivo()

            var bundle = Bundle()
            posaluno?.let { bundle.putInt("pos", posaluno) }
            bundle.putInt("position",position!!)
            bundle.putSerializable("turma", turminha)
            val int = Intent(context, ActivityDeletarDisciplina::class.java)
            int.putExtras(bundle)
            context.startActivity(int)
        }

        private fun editItem() {

            var turminha : Turma = abrirArquivo()
            var bundle = Bundle()
            posaluno?.let { bundle.putInt("pos", it) }
            position?.let { bundle.putInt("posDisc", it) }
            bundle.putSerializable("turma", turminha)

            val int = Intent(context, ActivityAddDisciplina::class.java)
            int.putExtras(bundle)
            context.startActivity(int)
        }
    }
    @Throws(IOException::class, ClassNotFoundException::class)
    fun abrirArquivo(): Turma {

        val fis = this.context.openFileInput("turma.dat")
        val ois = ObjectInputStream(fis)

        return ois.readObject() as Turma
    }
}