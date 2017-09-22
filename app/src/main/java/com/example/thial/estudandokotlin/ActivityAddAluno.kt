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

        var i : Intent = getIntent() as Intent
        val turma : Turma = i.getSerializableExtra("turma") as Turma


        mBtnSalvarAluno.setOnClickListener{
            var name = mEdtNomeAluno.text.toString()
            var matricula = mEdtMatriculaAluno.text.toString()
            toast("Nome: $name \n," +
                    "Matricula: $matricula")

            turma.addAluno(Aluno(name, matricula))
        }
    }

    fun toast(message: String, length: Int = Toast.LENGTH_LONG) {
        Toast.makeText(this, message, length).show()
    }
}
