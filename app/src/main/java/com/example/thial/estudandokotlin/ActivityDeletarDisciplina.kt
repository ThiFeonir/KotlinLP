package com.example.thial.estudandokotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_deletar.*
import java.io.IOException
import java.io.ObjectInputStream

class ActivityDeletarDisciplina : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deletar_disciplina)
        var i = getIntent() as Intent
        var bundle : Bundle = i.extras
        val turma : Turma = bundle.getSerializable("turma") as Turma
        var posaluno : Int = bundle.getInt("pos")
        var position: Int = bundle.getInt("position")

        mTxtNome.setText(turma.alunos.get(posaluno).disciplinas!!.get(position).nome)

        mBtnYes.setOnClickListener {
            val turminha: Turma = abrirArquivo()
            turma.alunos.get(posaluno).disciplinas!!.removeAt(position!!)
            ArquivoUtils(turma, applicationContext)
            finish()
        }

        mBtnNo.setOnClickListener {
            finish()
        }
    }

    override fun finish() {
        super.finish()
    }

    @Throws(IOException::class, ClassNotFoundException::class)
    fun abrirArquivo(): Turma {

        val fis = this.applicationContext.openFileInput("turma.dat")
        val ois = ObjectInputStream(fis)

        return ois.readObject() as Turma
    }

}
