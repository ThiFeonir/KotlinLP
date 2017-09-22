package com.example.thial.estudandokotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException
import java.io.ObjectInputStream

class MainActivity : AppCompatActivity() {

    val turma = Turma()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//      testando o listView de Disciplinas
        var disciplina: ArrayList<Disciplina>
        disciplina = ArrayList()
        disciplina.add(Disciplina("Estrutura de Dados II", 10.0, 10.0, 9.0))
        disciplina.add(Disciplina("Liguagens de Programação", 3.5, 7.0, 10.0))
        disciplina.add(Disciplina("Programação III", 10.0, 1.0, 1.0))
        disciplina.add(Disciplina("Teoria da computação", 10.0, 10.0, 8.0))
        disciplina.add(Disciplina("Estrutura de Dadoos I", 10.0, 10.0, 8.0))

        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = DisciplinaAdapter(this, disciplina)

        /*turma.alunos.add(Aluno("Weslley", "123"))
        turma.alunos.add(Aluno("Thiago", "1235"))
        turma.alunos.add(Aluno("Thayane", "1234"))
        turma.alunos.add(Aluno("Kelvin", "1253"))
        turma.alunos.add(Aluno("Carlos", "12253"))

        val arq = ArquivoUtils(turma, this.applicationContext)*/

/*        val turminha : Turma = this.abrirArquivo()

        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = AlunoAdapter(this,turminha.alunos)

        floatingActionButton.setOnClickListener({
            val i = Intent(this, ActivityAddAluno::class.java)
            i.putExtra("turma", turminha)
            startActivity(i)
        })

    }

    @Throws(IOException::class, ClassNotFoundException::class)
    fun abrirArquivo(): Turma {

        val fis = this.applicationContext .openFileInput("turma.dat")
        val ois = ObjectInputStream(fis)

        return ois.readObject() as Turma*/
    }
}

