package com.example.suficienciarecupmm2eva

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class ThirdActivity : AppCompatActivity() {

    private lateinit var txvLibro: TextView
    private lateinit var botonGuardar: Button
    private lateinit var botonVisualizar: Button
    private lateinit var botonVolver: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        txvLibro = findViewById(R.id.txvLibro)
        botonGuardar = findViewById(R.id.botonGuardar)
        botonVisualizar = findViewById(R.id.botonVisualizar)
        botonVolver = findViewById(R.id.botonVolver)

        val libro = intent.getSerializableExtra("libro") as Libro

        val texto = txvLibro.text.toString()+libro.toString()
        txvLibro.text = texto

        val dbHelper = DBManager(this)

        botonGuardar.setOnClickListener {
            dbHelper.escribir(libro)
            Toast.makeText(this,"Libro guardado en la BBDD",Toast.LENGTH_SHORT).show()
        }

        botonVisualizar.setOnClickListener {
            val intent = Intent(this,SaveActivity::class.java)
            startActivity(intent)
        }

        botonVolver.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}