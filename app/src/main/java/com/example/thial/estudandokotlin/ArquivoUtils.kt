package com.example.thial.estudandokotlin


import android.content.Context
import java.io.*

/**
 * Created by thial on 21/09/2017.
 */

class ArquivoUtils internal constructor( var turminha: Turma, var context : Context) {
    internal val fos = this.context.openFileOutput("turma.dat", Context.MODE_PRIVATE)
    internal val oos = ObjectOutputStream(fos)

    init {
        this.salvarArquivo()
        this.closeFile()
    }

    @Throws(IOException::class)
    fun criarArquivo() {
        val fos = this.context.openFileOutput("turma.dat", Context.MODE_PRIVATE)
        val oos = ObjectOutputStream(fos)
    }

    @Throws(IOException::class)
    private fun salvarArquivo() {
        oos.writeObject(turminha)
        this.closeFile()
    }

    @Throws(IOException::class)
    fun closeFile() {
        oos.close()
    }

    @Throws(IOException::class, ClassNotFoundException::class)
    fun abrirArquivo(): Turma {

        val fis = context.openFileInput("turma.dat")
        val ois = ObjectInputStream(fis)

        return ois.readObject() as Turma
    }
}
