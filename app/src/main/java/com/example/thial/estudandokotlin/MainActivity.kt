package com.example.thial.estudandokotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val turma = Turma()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

/*      testando o listView de Disciplinas
        var disciplina : ArrayList<Disciplina>
        disciplina = ArrayList()
        disciplina.add(Disciplina("Estrutura de Dados II", 10.0,10.0,9.0))
        disciplina.add(Disciplina("Liguagens de Programação", 3.5,7.0,10.0))
        disciplina.add(Disciplina("Programação III", 10.0,10.0,10.0))
        disciplina.add(Disciplina("Teoria da computação", 10.0,10.0,8.0))
        disciplina.add(Disciplina("Estrutura de Dadoos I", 10.0,10.0,8.0))

        var adapter : DisciplinasAdapter
        adapter = DisciplinasAdapter(this,disciplina)
        listAlunos.adapter = adapter*/


      /*  var aluno: ArrayList<Aluno>
        aluno = ArrayList()*/
        turma.alunos.add(Aluno("Weslley", "123"))
        turma.alunos.add(Aluno("Thiago", "1235"))
        turma.alunos.add(Aluno("Thayane", "1234"))
        turma.alunos.add(Aluno("Kelvin", "1253"))
        turma.alunos.add(Aluno("Carlos", "12253"))

        var adapter: AlunosAdapter
        adapter = AlunosAdapter(this,turma.alunos)
        listAlunos.adapter = adapter

        buttonaddaluno.setOnClickListener({
            val i = Intent(this, ActivityAddAluno::class.java)
            i.putExtra("turma", turma)
            startActivity(i)
        })


    }
}

