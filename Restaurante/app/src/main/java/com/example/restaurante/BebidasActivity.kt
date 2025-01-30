package com.example.restaurante

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class BebidasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bebidas)

        /*Botón para entrar en la aplicación del restaurante*/
        val botonAtras : ImageButton = findViewById(R.id.flecha)

        /*Accion que se hace cuando el usuario clica al botón*/
        botonAtras.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}