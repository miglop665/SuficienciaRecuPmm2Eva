package com.example.suficienciarecupmm2eva

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DBManager(context: Context) : SQLiteOpenHelper(context, DATABASE, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE = "LibrosDatabase"
        private const val TABLA_LIBROS = "Libros"
        private const val KEY_ID = "_id"
        private const val COLUMN_NOMBRE = "nombre"
        private const val COLUMN_PAGINAS = "paginas"
        private const val COLUMN_EDITORIAL = "editorial"
        private const val COLUMN_ANIO = "anio"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = "CREATE TABLE $TABLA_LIBROS ($KEY_ID INTEGER PRIMARY KEY, $COLUMN_NOMBRE TEXT, $COLUMN_PAGINAS INTEGER, $COLUMN_EDITORIAL TEXT, $COLUMN_ANIO INTEGER)"
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLA_LIBROS")
        onCreate(db)
    }

    fun escribir(libro:Libro){
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_NOMBRE, libro.getNombre())
            put(COLUMN_PAGINAS, libro.getPaginas())
            put(COLUMN_EDITORIAL, libro.getEditorial())
            put(COLUMN_ANIO, libro.getAnio())
        }
        db.insert(TABLA_LIBROS, null, values)
        db.close()
    }


    @SuppressLint("Range")
    fun lectura(): ArrayList<Libro> {
        val lectura = ArrayList<Libro>()
        val selectQuery = "SELECT * FROM $TABLA_LIBROS"
        val db = this.readableDatabase
        val cursor = db.rawQuery(selectQuery, null)
        if (cursor.moveToFirst()) {
            do {
                val nombre = cursor.getString(cursor.getColumnIndex(COLUMN_NOMBRE))
                val paginas = cursor.getInt(cursor.getColumnIndex(COLUMN_PAGINAS))
                val editorial = cursor.getString(cursor.getColumnIndex(COLUMN_EDITORIAL))
                val anio = cursor.getInt(cursor.getColumnIndex(COLUMN_ANIO))
                lectura.add(Libro(nombre, paginas, editorial, anio))
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return lectura
    }

}
