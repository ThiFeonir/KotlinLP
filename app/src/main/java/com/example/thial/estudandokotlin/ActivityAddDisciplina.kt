package com.example.thial.estudandokotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_disciplina.*

class ActivityAddDisciplina : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_disciplina)

        var i : Intent = getIntent() as Intent
        var bundle : Bundle = i.extras

        val turminha : Turma = bundle.getSerializable("turma") as Turma
        var pos : Int = bundle.getInt("pos")
        var posDisc : Int = bundle.getInt("posDisc")

        mBtnSalvarDisciplina.setOnClickListener{
            val nome = mEdtNomeDisciplina.text.toString()
            var nota1: Double = mEdtNota1.text.toString().toDouble()
            var nota2: Double = mEdtNota2.text.toString().toDouble()
            var nota3: Double = mEdtNota3.text.toString().toDouble()

            if(posDisc == -1) {
                turminha.alunos.get(pos).addDisciplina(Disciplina(nome, nota1, nota2, nota3))
                ArquivoUtils(turminha, this)
                finish()
            }else{
                turminha.alunos.get(pos).disciplinas!!.set(posDisc, Disciplina(nome, nota1, nota2, nota3))
                ArquivoUtils(turminha, this)
                finish()
            }
        }
    }
}
