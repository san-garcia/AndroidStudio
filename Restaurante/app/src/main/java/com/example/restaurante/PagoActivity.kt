package com.example.restaurante

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class PagoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pago)

        // Recibimos los datos del Intent
        val productos = intent.getStringArrayListExtra("productos") ?: arrayListOf()
        val total = intent.getDoubleExtra("total", 0.0)

        // Declaro los elementos
        val listaProductos = findViewById<ListView>(R.id.productos)
        val totalTextView = findViewById<TextView>(R.id.total)
        val botonPagar = findViewById<Button>(R.id.btnPagar)

        // Mustro el total
        totalTextView.text = "Total: %.2f€".format(total)

        // Mustro los productos en la ListView
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, productos)
        listaProductos.adapter = adapter

        // Configuro el botón de pagar
        botonPagar.setOnClickListener {
            // Borra el total cuando se presiona el botón
            totalTextView.text = "Total: 0.00€"
        }

        // Botón para volver a la pantalla anterior
        val botonAtras: ImageButton = findViewById(R.id.flecha)

        botonAtras.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}

