package com.example.thial.estudandokotlin

import java.io.Serializable
import java.util.ArrayList

/**
 * Created by thial on 19/09/2017.
 */
internal class Turma() : Serializable {

    private val alunos: ArrayList<Aluno>

    init {
        alunos = ArrayList()
    }

    fun addAluno(aluno: Aluno) {
        alunos.add(aluno)
    }
}
