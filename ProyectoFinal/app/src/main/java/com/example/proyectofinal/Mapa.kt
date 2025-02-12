package com.example.proyectofinal

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class Mapa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapa)

        val botonAtras : ImageButton = findViewById(R.id.flecha)

        botonAtras.setOnClickListener {
            val intent = Intent(this, Perfil::class.java)
            startActivity(intent)

        }

    }

}
