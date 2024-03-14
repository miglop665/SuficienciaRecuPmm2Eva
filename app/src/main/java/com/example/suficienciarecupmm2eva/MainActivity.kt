package com.example.suficienciarecupmm2eva

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    private lateinit var nombre:EditText
    private lateinit var paginas:EditText
    private lateinit var botonSiguiente:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nombre = findViewById(R.id.edtNombre)
        paginas = findViewById(R.id.edtPaginas)
        botonSiguiente = findViewById(R.id.botonSiguiente)

        botonSiguiente.setOnClickListener {
            try{
                if(nombre.text.toString().isNotBlank() && paginas.text.toString().isNotBlank() && paginas.text.toString().toInt() in (1..1000)){
                    val intent = Intent(this,SecondActivity::class.java)
                    intent.putExtra("libro",Libro(nombre.text.toString(),paginas.text.toString().toInt(),null,null))
                    startActivity(intent)
                }else{
                    if(nombre.text.toString().isBlank()){
                        Toast.makeText(this,"El nombre no puede estar vacio...",Toast.LENGTH_SHORT).show()
                    }else{
                        if(paginas.text.toString().isBlank()){
                            Toast.makeText(this,"El numero de paginas no puede estar vacio...",Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this,"El numero de paginas debe estar entre 1 y 1000",Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }catch(e:NumberFormatException){
                Toast.makeText(this,"Introduce los datos que tocan perro...",Toast.LENGTH_SHORT).show()
            }
        }
    }
}