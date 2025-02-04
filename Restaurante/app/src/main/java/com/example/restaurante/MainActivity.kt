package com.example.restaurante

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import androidx.activity.enableEdgeToEdge

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Botón para entrar en la aplicación del restaurante
        val botonMesas : Button = findViewById(R.id.botonDistribucion)

        // Botón para entrar a la carta
        val botonCarta : Button = findViewById(R.id.botonAlimentos)

        // Botón para entrar a las bebidas
        val botonBebidas : Button = findViewById(R.id.botonBebidas)


        // Accion que se hace cuando el usuario clica al botón para pedir reserva en las mesas
        botonMesas.setOnClickListener {
            val intent = Intent(this, MesaActivity::class.java)
            startActivity(intent)
        }

        // Accion que hace el usuario para pedir en la carta
        botonCarta.setOnClickListener {
            val intent = Intent(this, CartaActivity::class.java)
            startActivity(intent)
        }

        // Accion que realiza el usuario para pedir las bebidas
        botonBebidas.setOnClickListener {
            val intent = Intent(this, BebidasActivity::class.java)
            startActivity(intent)
        }
    }
}