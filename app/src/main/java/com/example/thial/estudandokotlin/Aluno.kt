package com.example.thial.estudandokotlin

import java.io.Serializable
import java.util.ArrayList

/**
 * Created by weslley on 19/09/2017.
 */

/*
class Aluno(nome: String, matricula: String) {

    var nome : String? = null
    var matricula : String? = null

    init {
        this.nome = nome
        this.matricula = matricula
    }
}


*/


class Aluno : Serializable {

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
