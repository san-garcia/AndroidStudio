package com.example.proyectofinal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /*Declaración de los botones de la app*/
        val iniciarSesion = findViewById<Button>(R.id.iniciarSesion)
        val registrarse = findViewById<Button>(R.id.registrarse)

        /*Accion que hará el usuario al clicar al boton de Iniciar sesión*/
        iniciarSesion.setOnClickListener {
            val intent = Intent(this, Sesion::class.java)
            startActivity(intent)
        }

        /*Accion que hará el usuario al clicar al boton de Registrarse*/
        registrarse.setOnClickListener {
            val intent = Intent(this, Registro::class.java)
            startActivity(intent)
        }
    }
}