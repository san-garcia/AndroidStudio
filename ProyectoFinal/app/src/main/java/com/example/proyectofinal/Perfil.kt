package com.example.proyectofinal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Perfil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_perfil)

        // Botones principales
        val botonMapa : Button = findViewById(R.id.botonMapa)
        val botonConocer : Button = findViewById(R.id.botonConocer)
        val botonChat : Button = findViewById(R.id.botonChat)
        val botonAjustes : ImageButton = findViewById(R.id.botonAjustes)
        val botonAyuda : ImageButton = findViewById(R.id.botonAyuda)
        val botonEmergencia : ImageButton = findViewById(R.id.botonEmergencia)

        botonMapa.setOnClickListener {
            val intent = Intent(this, Mapa::class.java)
            startActivity(intent)
        }

        botonConocer.setOnClickListener {
            val intent = Intent(this, Mujeres::class.java)
            startActivity(intent)
        }

        botonChat.setOnClickListener {
            val intent = Intent(this, Chat::class.java)
            startActivity(intent)
        }

        botonAjustes.setOnClickListener {
            val intent = Intent(this, Ajustes::class.java)
            startActivity(intent)
        }

        botonAyuda.setOnClickListener {
            val intent = Intent(this, Ayuda::class.java)
            startActivity(intent)
        }

        botonEmergencia.setOnClickListener {
            val intent = Intent(this, Emergencia::class.java)
            startActivity(intent)
        }


    }
}