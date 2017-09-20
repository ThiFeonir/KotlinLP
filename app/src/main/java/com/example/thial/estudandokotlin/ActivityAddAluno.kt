package com.example.thial.estudandokotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_aluno.*

class ActivityAddAluno : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_aluno)

        mBtnSalvarAluno.setOnClickListener{
            var name = mEdtNome.text
            var matricula = mEdtMatricula.text
            toast("Nome: $name \n," +
                    "Matricula: $matricula")
        }
    }

    fun toast(message: String, length: Int = Toast.LENGTH_LONG) {
        Toast.makeText(this, message, length).show()
    }
}
