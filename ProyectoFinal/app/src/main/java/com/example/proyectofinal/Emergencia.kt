package com.example.proyectofinal

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Emergencia : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_emergencia)

        val botonAtras : ImageButton = findViewById(R.id.flecha)

        botonAtras.setOnClickListener {
            val intent = Intent(this, Perfil::class.java)
            startActivity(intent)

        }

    }
}