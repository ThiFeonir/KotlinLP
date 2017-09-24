package com.example.thial.estudandokotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_deletar.*
import java.io.IOException
import java.io.ObjectInputStream

class ActivityDeletar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deletar)

        var i = getIntent() as Intent
        var bundle : Bundle = i.extras

        val turma : Turma = bundle.getSerializable("turma") as Turma
        var pos : Int = bundle.getInt("pos")

        mTxtNome.setText(turma.alunos.get(pos).nome)

        mBtnYes.setOnClickListener {
            val turminha: Turma = abrirArquivo()
            turminha.alunos.removeAt(pos!!)
            ArquivoUtils(turminha, this)
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
