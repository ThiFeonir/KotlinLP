package com.example.thial.estudandokotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_aluno.*
import android.content.Intent



class ActivityAddAluno : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_aluno)

        var turma : Turma = intent.getSerializableExtra("turminha") as Turma

        mBtnSalvarAluno.setOnClickListener{
            var name = mEdtNomeAluno.text.toString()
            var matricula = mEdtMatriculaAluno.text.toString()
            toast("$name adicionado!!!")
            turma.alunos.add(Aluno(name, matricula))
            ArquivoUtils(turma, this)
            finish()
        }
    }

    override fun finish() { super.finish() }

    fun toast(message: String, length: Int = Toast.LENGTH_LONG) {
        Toast.makeText(this, message, length).show()
    }
}
