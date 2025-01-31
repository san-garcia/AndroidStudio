package com.example.restaurante

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class BebidasActivity : AppCompatActivity() {

    // Variable para almacenar el total
    private var total = 0.0

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

        // TextView donde se mostrará el total
        val totalTextView: TextView = findViewById(R.id.total)

        // Lista de productos con sus precios
        val productos = mapOf(
            R.id.agua to 1.2, R.id.cocacola to 2.5, R.id.estrelladam to 3.5, R.id.vichycatalan to 5.0, R.id.vinoblanco to 24.5,
            R.id.perafita to 26.5
        )

        // Agregar listeners a las imágenes para sumar al total
        for ((id, precio) in productos) {
            val producto = findViewById<ImageButton>(id)
            producto?.setOnClickListener {
                total += precio
                totalTextView.text = "Total: %.2f€".format(total)
            }
        }

        /*Declaro el boton de pagar para redirigirme a la confirmación de pago*/
        val botonPago : Button = findViewById(R.id.pago)

        /*Accion que se hace cuando el usuario ya ha elegido lo que quiere y el camarero le da a pagar*/
        botonPago.setOnClickListener {
            val intent = Intent(this, PagoActivity::class.java)
            startActivity(intent)
        }

    }
}