package com.example.thial.estudandokotlin

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.view.View
import kotlinx.android.synthetic.main.content_activity_exibir_disciplinas.*

class ActivityExibirDisciplinas : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exibir_disciplinas)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        var disciplina: ArrayList<Disciplina>
        disciplina = ArrayList()
        disciplina.add(Disciplina("Estrutura de Dados II", 10.0, 10.0, 9.0))
        disciplina.add(Disciplina("Liguagens de Programação", 3.5, 7.0, 10.0))
        disciplina.add(Disciplina("Programação III", 10.0, 1.0, 1.0))
        disciplina.add(Disciplina("Teoria da computação", 10.0, 10.0, 8.0))
        disciplina.add(Disciplina("Estrutura de Dadoos I", 10.0, 10.0, 8.0))

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = DisciplinaAdapter(this, disciplina)


        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

}
