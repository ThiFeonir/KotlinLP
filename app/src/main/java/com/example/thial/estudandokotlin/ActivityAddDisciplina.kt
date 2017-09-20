package com.example.thial.estudandokotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_disciplina.*

class ActivityAddDisciplina : AppCompatActivity() {
    private val aluno = Aluno()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_disciplina)

        mBtnSalvarDisciplina.setOnClickListener{
            val nome = mEdtNomeDisciplina.text.toString()
            var nota1: Double = mEdtNota1.text.toString().toDouble()
            var nota2: Double = mEdtNota2.text.toString().toDouble()
            var nota3: Double = mEdtNota3.text.toString().toDouble()

            toast("Nome: $nome \n" +
                    "Nota 1: $nota1 \n"+
                    "Nota 2: $nota2 \n"+
                    "Nota 3: $nota3 \n")

            aluno.addDisciplina(Disciplina(nome, nota1, nota2, nota3))
        }
    }

    fun toast(message: String, length: Int = Toast.LENGTH_LONG) {
        Toast.makeText(this, message, length).show()
    }
}
