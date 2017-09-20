package com.example.thial.estudandokotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_add_aluno.*

class ActivityAddAluno : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_aluno)

        var nome = findViewById(R.id.mEdtNome) as EditText
        var matricular = findViewById(R.id.mEdtMatricula) as EditText

    }
}
