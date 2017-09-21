package com.example.thial.estudandokotlin

import android.provider.MediaStore

import java.io.File
import java.io.File.*
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.util.NoSuchElementException

/**
 * Created by thial on 21/09/2017.
 */

class ArquivoUtils internal constructor(internal var turminha: Turma) {

    internal lateinit var fos: FileOutputStream
    internal lateinit var oos: ObjectOutputStream

    init {
        criarArquivo()
        salvarArquivo()
        closeFile()
    }

    @Throws(IOException::class)
    fun criarArquivo() {
        fos = FileOutputStream("turma.dat")
        oos = ObjectOutputStream(fos)
    }

    @Throws(IOException::class)
    fun salvarArquivo() {
        oos.writeObject(turminha)
    }

    @Throws(IOException::class)
    fun closeFile() {
        oos.close()
    }

    @Throws(IOException::class, ClassNotFoundException::class)
    fun abrirArquivo(): Turma {

        val fis = FileInputStream("turma.dat")
        val ois = ObjectInputStream(fis)

        return ois.readObject() as Turma
    }
}
