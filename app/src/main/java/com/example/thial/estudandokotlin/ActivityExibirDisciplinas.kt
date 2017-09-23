package com.example.thial.estudandokotlin

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import kotlinx.android.synthetic.main.content_activity_exibir_disciplinas.*
import java.io.IOException
import java.io.ObjectInputStream

class ActivityExibirDisciplinas : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exibir_disciplinas)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        var i : Intent = getIntent() as Intent
        var bundle : Bundle = i.extras

        val turma: Turma = this.abrirArquivo()
        var pos : Int = bundle.getInt("pos")

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = DisciplinaAdapter(this, turma.alunos.get(pos).disciplinas!!, pos)

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->

            var bundle = Bundle()
            pos?.let { bundle.putInt("pos", it) }
            bundle.putInt("posDisc", -1)
            val turminha: Turma = this.abrirArquivo()  //quando vai passar a turma para a activity de adicionar, precisa abrir o arquivo de novo
            //para atualizar
            bundle.putSerializable("turma", turminha)

            val int = Intent(this, ActivityAddDisciplina::class.java)
            int.putExtras(bundle)
            startActivity(int)
        }
    }

    override fun onRestart() {
        super.onRestart()

        var i : Intent = getIntent() as Intent
        var bundle : Bundle = i.extras

        var pos : Int = bundle.getInt("pos")

        val turminha: Turma = this.abrirArquivo()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = DisciplinaAdapter(this, turminha.alunos.get(pos).disciplinas!!, pos)

    }

    @Throws(IOException::class, ClassNotFoundException::class)
    fun abrirArquivo(): Turma {

        val fis = this.applicationContext.openFileInput("turma.dat")
        val ois = ObjectInputStream(fis)

        return ois.readObject() as Turma
    }
}
