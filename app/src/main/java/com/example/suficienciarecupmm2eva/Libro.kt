package com.example.suficienciarecupmm2eva

import java.io.Serializable

class Libro(
    private var nombre:String,
    private var paginas:Int,
    private var editorial: String?,
    private var anio: Int?
):Serializable {

    fun getNombre(): String {
        return nombre
    }
    fun getPaginas(): Int {
        return paginas
    }
    fun getEditorial(): String? {
        return editorial
    }fun getAnio(): Int? {
        return anio
    }

    fun setEditorial(editorial:String){
        this.editorial=editorial
    }
    fun setAnio(anio:Int){
        this.anio=anio
    }

    override fun toString(): String {
        return "Libro: [Nombre: $nombre, Paginas: $paginas, Editorial: $editorial, Año: $anio]"
    }
}