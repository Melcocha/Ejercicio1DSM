package com.example.ejercicio1

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.InputFilter
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nombreEditText: EditText = findViewById(R.id.nombreEditText)
        val nota1EditText: EditText = findViewById(R.id.nota1EditText)
        val nota2EditText: EditText = findViewById(R.id.nota2EditText)
        val nota3EditText: EditText = findViewById(R.id.nota3EditText)
        val nota4EditText: EditText = findViewById(R.id.nota4EditText)
        val nota5EditText: EditText = findViewById(R.id.nota5EditText)
        val calcularButton: Button = findViewById(R.id.calcularButton)
        val resultadoTextView: TextView = findViewById(R.id.resultadoTextView)

        // Aplicar filtro a todos los EditText de notas para aceptar solo números del 0 al 10
        val filter = InputFilter { source, _, _, _, _, _ ->
            if (source.toString().matches("[0-9]*".toRegex())) {
                val input = source.toString().toInt()
                if (input in 0..10) null else ""
            } else ""
        }
        nota1EditText.filters = arrayOf(filter)
        nota2EditText.filters = arrayOf(filter)
        nota3EditText.filters = arrayOf(filter)
        nota4EditText.filters = arrayOf(filter)
        nota5EditText.filters = arrayOf(filter)

        calcularButton.setOnClickListener {
            val nombre = nombreEditText.text.toString()
            val nota1 = nota1EditText.text.toString().toDouble()
            val nota2 = nota2EditText.text.toString().toDouble()
            val nota3 = nota3EditText.text.toString().toDouble()
            val nota4 = nota4EditText.text.toString().toDouble()
            val nota5 = nota5EditText.text.toString().toDouble()

            val promedio = (nota1 + nota2 + nota3 + nota4 + nota5) / 5
            val resultado = "El promedio de $nombre es: $promedio\n"
            val mensaje = if (promedio >= 6) "Aprobado" else "Reprobado"

            resultadoTextView.text = "$resultado$mensaje"
        }
    }
}