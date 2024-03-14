package com.example.suficienciarecupmm2eva

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SaveActivity : AppCompatActivity() {

    private lateinit var txvLibros: TextView
    private lateinit var botonVolver: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save)

        txvLibros = findViewById(R.id.txvLibros)
        botonVolver = findViewById(R.id.botonVolver)

        val dbHelper = DBManager(this)
        val listaLibros = dbHelper.lectura()

        var texto= txvLibros.text.toString()
        for(libro in listaLibros){
            texto += libro.toString()+"\n"+"\n"
        }
        txvLibros.text = texto

        botonVolver.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}