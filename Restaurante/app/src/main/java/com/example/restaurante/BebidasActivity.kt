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

    // Lista de productos con sus precios
    private val productosSeleccionados = mutableMapOf<String, Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bebidas)

        // Botón para ir hacia atrás aplicación del restaurante
        val botonAtras : ImageButton = findViewById(R.id.flecha)

        // Accion que se hace cuando el usuario clica al botón
        botonAtras.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // TextView donde se mostrará el total
        val totalTextView: TextView = findViewById(R.id.total)

        // Lista de productos con sus precios
        val productos = mapOf(
            R.id.agua to Pair("Agua", 1.2),
            R.id.cocacola to Pair("Coca-Cola", 2.0),
            R.id.estrelladam to Pair ("Estrellita de mani", 3.5),
            R.id.vichycatalan to Pair("Vichy Catalan", 5.0),
            R.id.vinoblanco to Pair("Vino blanco", 24.5),
            R.id.perafita to Pair( "Perafita", 22.0)
        )

        // Recorro los productos y los añadimos a la lista
        for ((id, data) in productos) {
            val producto = findViewById<ImageButton>(id)
            producto?.setOnClickListener {
                // Aumentar el contador del producto en la lista
                productosSeleccionados[data.first] = productosSeleccionados.getOrDefault(data.first, 0) + 1
                total += data.second

                // Actualizamos el total en pantalla
                totalTextView.text = "Total: %.2f€".format(total)
            }
        }

        // Declaro el boton de pagar para redirigirme a la confirmación de pago
        val botonPago : Button = findViewById(R.id.pago)

        // Accion que se hace cuando el usuario ya ha elegido lo que quiere y el camarero le da a pagar
        botonPago.setOnClickListener {
            // Crear una lista con los productos y sus cantidades
            val resumenProductos = productosSeleccionados.map { (nombre, cantidad) -> "$nombre x$cantidad" }

            // Crear un intent para ir a la actividad de pago
            val intent = Intent(this, PagoActivity::class.java).apply {
                putExtra("productos", ArrayList(resumenProductos))
                putExtra("total", total)
            }
            startActivity(intent)
        }

    }
}