package com.example.formularios

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        /*Texto*/
        val textViewFormulario : TextView = findViewById(R.id.textViewFormulario)

        /*Botones busco y ofrezco trabajo*/
        val botonBusco : Button = findViewById(R.id.botonBusco)
        val botonOfrezco : Button = findViewById(R.id.botonOfrezco)

        /*Accion que hace el usuario al clicar al boton Busco empleo*/
        botonBusco.setOnClickListener {
            val intent = Intent(this, FirstActivity::class.java)
            startActivity(intent)
        }

        /*Accion que hace el usuario al clicar al boton Ofrezco empleo*/
        botonOfrezco.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

    }

}