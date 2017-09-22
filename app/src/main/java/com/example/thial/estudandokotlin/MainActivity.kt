package com.example.thial.estudandokotlin

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import kotlinx.android.synthetic.main.content_main.*
import java.io.IOException
import java.io.ObjectInputStream

class MainActivity : AppCompatActivity() {

    val turma = Turma()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        turma.alunos.add(Aluno("Weslley", "123"))
        turma.alunos.add(Aluno("Thiago", "1235"))
        turma.alunos.add(Aluno("Thayane", "1234"))
        turma.alunos.add(Aluno("Kelvin", "1253"))
        turma.alunos.add(Aluno("Carlos", "12253"))

        val arq = ArquivoUtils(turma, this.applicationContext)

        val turminha : Turma = this.abrirArquivo()

        recyclerViewAluno.layoutManager = LinearLayoutManager(this)
        recyclerViewAluno.adapter = AlunoAdapter(this, turminha.alunos)

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            val i = Intent(this,ActivityAddAluno::class.java)
            i.putExtra("turma", turminha)
            startActivity(i)
        }
    }

    @Throws(IOException::class, ClassNotFoundException::class)
    fun abrirArquivo(): Turma {

        val fis = this.applicationContext .openFileInput("turma.dat")
        val ois = ObjectInputStream(fis)

        return ois.readObject() as Turma
    }

}
/*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                  .setAction("Action", null).show()*/