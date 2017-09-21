package com.example.thial.estudandokotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

/**
 * Created by Weslley on 20/09/2017.
 */
class DisciplinasAdapter(context: Context, lista: ArrayList<Disciplina>) : BaseAdapter() {

    var disciplinaLista: ArrayList<Disciplina>? = null
    var inflater: LayoutInflater? = null

    init {
        disciplinaLista = lista
        inflater = LayoutInflater.from(context)
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var view: View? = null

        view = inflater?.inflate(R.layout.disciplina_linha, parent,false)

        var mTxtDisciplina : TextView = view?.findViewById(R.id.mTxtDisciplina) as TextView
        var mTxtNota1 : TextView = view?.findViewById(R.id.mTxtNota1) as TextView
        var mTxtNota2 : TextView = view?.findViewById(R.id.mTxtNota2) as TextView
        var mTxtNota3 : TextView = view?.findViewById(R.id.mTxtNota3) as TextView

        var disciplina: Disciplina
        disciplina = getItem(position)!!

        mTxtDisciplina.setText(disciplina.nome)
        mTxtNota1.setText(disciplina.nota1.toString())
        mTxtNota2.setText(disciplina.nota2.toString())
        mTxtNota3.setText(disciplina.nota3.toString())

        return view!!
    }

    override fun getItem(position: Int): Disciplina? {
        return disciplinaLista?.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return disciplinaLista!!.size
    }
}
