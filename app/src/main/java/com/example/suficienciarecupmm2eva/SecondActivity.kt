package com.example.suficienciarecupmm2eva

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SecondActivity : AppCompatActivity() {

    private lateinit var editorial: EditText
    private lateinit var anio: EditText
    private lateinit var botonSiguiente: Button
    private lateinit var botonVolver: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        editorial = findViewById(R.id.edtEditorial)
        anio = findViewById(R.id.edtAnio)
        botonSiguiente = findViewById(R.id.botonSiguiente)
        botonVolver = findViewById(R.id.botonVolver)

        val libro = intent.getSerializableExtra("libro") as Libro

        botonSiguiente.setOnClickListener {
            try{
                if(editorial.text.toString().isNotBlank() && anio.text.toString().isNotBlank() && anio.text.toString().toInt() in (1900..2024)){
                    val intent = Intent(this,ThirdActivity::class.java)
                    libro.setEditorial(editorial.text.toString())
                    libro.setAnio(anio.text.toString().toInt())
                    intent.putExtra("libro",libro)
                    startActivity(intent)
                }else{
                    if(editorial.text.toString().isBlank()){
                        Toast.makeText(this,"La editorial no puede estar vacia...", Toast.LENGTH_SHORT).show()
                    }else{
                        if(anio.text.toString().isBlank()){
                            Toast.makeText(this,"El año no puede estar vacio...", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this,"El año debe estar entre 1900 y 2024", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }catch(e : NumberFormatException){
                Toast.makeText(this,"Introduce los datos que tocan perro...", Toast.LENGTH_SHORT).show()
            }
        }
        botonVolver.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}