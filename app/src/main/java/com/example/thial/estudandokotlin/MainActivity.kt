package com.example.thial.estudandokotlin

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import kotlinx.android.synthetic.main.content_main.*
import java.io.File
import java.io.IOException
import java.io.ObjectInputStream

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        var turma : Turma
        var file = File("turma.dat")

        if(file.exists()) {
            turma = this.abrirArquivo()
        }else{
            turma = Turma()
            ArquivoUtils(turma, this.applicationContext)
        }

        recyclerViewAluno.layoutManager = LinearLayoutManager(this)
        recyclerViewAluno.adapter = AlunoAdapter(this, turma)

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->

            val turminha: Turma = this.abrirArquivo()  //quando vai passar a turma para a activity de adicionar, precisa abrir o arquivo de novo
            //para atualizar
            var bundle = Bundle()
            bundle.putInt("pos", -1)
            bundle.putSerializable("turma", turminha)
            val i = Intent(this, ActivityAddAluno::class.java)
            i.putExtras(bundle)
            startActivity(i)
        }
    }

    @Throws(IOException::class, ClassNotFoundException::class)
    fun abrirArquivo(): Turma {

        val fis = this.applicationContext.openFileInput("turma.dat")
        val ois = ObjectInputStream(fis)

        return ois.readObject() as Turma
    }

    override fun onRestart() {
        super.onRestart()
        val turminha: Turma = this.abrirArquivo()
        recyclerViewAluno.layoutManager = LinearLayoutManager(this)
        recyclerViewAluno.adapter = AlunoAdapter(this, turminha)

    }
}