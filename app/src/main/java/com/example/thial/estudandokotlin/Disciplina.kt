package com.example.thial.estudandokotlin

import java.util.ArrayList

/**
 * Created by thial on 19/09/2017.
 */
internal class Disciplina {

    var notas : ArrayList<Double>? = null
        private set
    var nome: String? = null

    constructor(nome: String) {
        notas = ArrayList()
        this.nome = nome
    }
    constructor(notas: ArrayList<Double>) {
        this.notas = notas
    }

    fun addNota(nota: Double) {
        notas!!.add(nota)
    }
}
