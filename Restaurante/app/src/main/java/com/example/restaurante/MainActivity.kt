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

        /*Botón para entrar en la aplicación del restaurante*/
        val botonEntrar : Button = findViewById(R.id.botonEntrar)

        /*Accion que se hace cuando el usuario clica al botón*/
        botonEntrar.setOnClickListener {
            val intent = Intent(this, CartaActivity::class.java)
            startActivity(intent)
        }
    }
}