package com.example.thial.estudandokotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_aluno.*
import kotlinx.android.synthetic.main.activity_deletar.*

class ActivityAddAluno : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_aluno)

        var i : Intent = getIntent() as Intent
        var bundle : Bundle = i.extras

        val turma : Turma = bundle.getSerializable("turma") as Turma
        var pos : Int = bundle.getInt("pos")

        if (pos !== -1) {
            mEdtNomeAluno.setText(turma.alunos.get(pos).nome)
            mEdtMatriculaAluno.setText(turma.alunos.get(pos).matricula)
        }

        mBtnSalvarAluno.setOnClickListener{

            var name = mEdtNomeAluno.text.toString()
            var matricula = mEdtMatriculaAluno.text.toString()

            if(pos == -1) {
                toast("$name adicionado!!!")
                turma.alunos.add(Aluno(name, matricula))
                ArquivoUtils(turma, this)
                finish()
            }else {
                toast("$name editado!!!")
                turma.alunos.set(pos, Aluno(name, matricula))
                ArquivoUtils(turma, this)
                finish()
            }
        }
    }

    override fun finish() { super.finish() }

    fun toast(message: String, length: Int = Toast.LENGTH_LONG) {
        Toast.makeText(this, message, length).show()
    }
}