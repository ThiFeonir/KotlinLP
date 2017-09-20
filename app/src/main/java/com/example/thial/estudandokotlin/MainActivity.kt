package com.example.thial.estudandokotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    internal val turma = Turma()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnTeste.setOnClickListener{
            val i = Intent(this, ActivityAddAluno::class.java)
            i.putExtra("turma", turma)
            startActivity(i)
        }
    }
}
