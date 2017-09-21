package com.example.thial.estudandokotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

/**
 * Created by Weslley on 21/09/2017.
 */
class AlunosAdapter(context: Context, lista: ArrayList<Aluno>) : BaseAdapter() {

    var alunoLista: ArrayList<Aluno>? = null
    var inflater: LayoutInflater? = null

    init {
        alunoLista = lista
        inflater = LayoutInflater.from(context)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View? = null

        view = inflater?.inflate(R.layout.alunos_linhas,parent,false)

        var mTxtAluno: TextView = view?.findViewById(R.id.mTxtAluno) as TextView
        var mTxtNumMat: TextView = view?.findViewById(R.id.mTxtNumMatricula) as TextView

        var aluno: Aluno
        aluno = getItem(position)!!

        mTxtAluno.setText(aluno.nome)
        mTxtNumMat.setText(aluno.matricula)

        return view!!
    }

    override fun getItem(position: Int): Aluno? {
        return alunoLista?.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return alunoLista!!.size
    }
}

private class ListRowHolder(row: View?) {
    public val campo: TextView

    init {
        this.campo = row?.findViewById(R.id.mTxtAluno) as TextView
    }
}
