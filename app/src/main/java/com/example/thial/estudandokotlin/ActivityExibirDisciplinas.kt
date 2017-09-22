package com.example.thial.estudandokotlin

import android.content.Intent
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

        var i : Intent = getIntent() as Intent
        val disciplinas : ArrayList<Disciplina> = i.getSerializableExtra("disciplinas") as ArrayList<Disciplina>

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = DisciplinaAdapter(this, disciplinas)


        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

}
