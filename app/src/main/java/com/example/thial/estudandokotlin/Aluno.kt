package com.example.thial.estudandokotlin

import java.util.ArrayList

/**
 * Created by thial on 19/09/2017.
 */
internal class Aluno {

    var disciplinas: ArrayList<Disciplina>? = null
        private set
    var nome: String? = null
    var matricula: String? = null

    constructor() {
        disciplinas = ArrayList()
    }

    constructor(nome: String, matricula: String) {
        this.nome = nome
        this.matricula = matricula
        disciplinas = ArrayList()
    }

    fun addDisciplina(disciplina: Disciplina) {
        disciplinas!!.add(disciplina)
    }
}
