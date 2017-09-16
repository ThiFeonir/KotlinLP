package com.example.thial.estudandokotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnTeste.setOnClickListener{Toast.makeText(this,"Boa aprendeu a usar botão, PARABÉNS!!",Toast.LENGTH_SHORT).show()}
    }
}
