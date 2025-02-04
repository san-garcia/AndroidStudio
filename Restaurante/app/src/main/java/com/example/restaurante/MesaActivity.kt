package com.example.restaurante

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MesaActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mesa)

        // Botón para ir hacia atrás aplicación del restaurante
        val botonAtras : ImageButton = findViewById(R.id.flecha)

        // Lista con todas las mesas
        val mesas = listOf(
            R.id.mesa100, R.id.mesa101, R.id.mesa102,
            R.id.mesa200, R.id.mesa201, R.id.mesa202,
            R.id.mesa300, R.id.mesa301, R.id.mesa302
        )

        // Accion que se hace cuando el usuario clica al botón para ir hacia atras
        botonAtras.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Accion que efectuará el camarero al elegir la mesa para los clientes
        for (mesaId in mesas) {
            findViewById<ImageButton>(mesaId).setOnClickListener {
                val intent = Intent(this, CartaActivity::class.java)
                startActivity(intent)
            }
        }

    }
}