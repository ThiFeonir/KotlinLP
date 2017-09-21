package com.example.thial.estudandokotlin


/**
 * Created by thial on 19/09/2017.
 */
class Disciplina (nome: String, nota1 : Double, nota2 : Double, nota3 : Double){

    var nome: String? = null
    var nota1: Double? = null
    var nota2: Double? = null
    var nota3: Double? = null


    init {
        this.nome = nome
        this.nota1 = nota1
        this.nota2 = nota2
        this.nota3 = nota3
    }
}
