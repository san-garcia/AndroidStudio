package com.example.restaurante

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class CartaActivity : AppCompatActivity() {
    // Variable para almacenar el total
    private var total = 0.0

    // Lista de productos con sus precios
    private val productosSeleccionados = mutableMapOf<String, Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_carta)

        // Botón para ir hacia atrás aplicación del restaurante
        val botonAtras: ImageButton = findViewById(R.id.flecha)

        // Accion que se hace cuando el usuario clica al botón
        botonAtras.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // TextView donde se mostrará el total
        val totalTextView: TextView = findViewById(R.id.total)

        // Lista de productos con sus precios
        val productos = mapOf(
            R.id.sushi1 to Pair("Roll de salmón y aguacate", 5.0),
            R.id.sushi2 to Pair("Nigiri de atún", 6.0),
            R.id.sushi3 to Pair("Maki atún", 4.5),
            R.id.sushi4 to Pair("Nigiri salmón", 7.0),
            R.id.sushi5 to Pair("Nigiri de lubina", 5.5),
            R.id.sushi6 to Pair("Mango roll", 6.5),
            R.id.sushi7 to Pair("Nigiri de gambas", 8.0),
            R.id.sushi8 to Pair("Uramaki sake tataki", 7.5),
            R.id.poke1 to Pair("Snack de edamame", 9.0),
            R.id.poke2 to Pair("Alga wakame", 10.0),
            R.id.poke3 to Pair("Atún oni oni", 8.5),
            R.id.poke4 to Pair("Salmón lomi lomi", 11.0),
            R.id.poke5 to Pair("Mango moa", 9.5),
            R.id.poke6 to Pair("Opae paina", 10.5),
            R.id.poke7 to Pair("Pomaikai", 12.0),
            R.id.poke8 to Pair("Kaleponia", 11.5),
            R.id.especial1 to Pair("Cigala Pasión", 13.0),
            R.id.especial2 to Pair("Vieira Yaku", 14.0),
            R.id.especial4 to Pair("Tataki Sake", 15.0)
        )

        // Recorro los productos y los añadimos a la lista
        for ((id, data) in productos) {
            val producto = findViewById<ImageButton>(id)
            producto?.setOnClickListener {
                productosSeleccionados[data.first] = productosSeleccionados.getOrDefault(data.first, 0) + 1 // Aumento el contador del producto en la lista
                total += data.second

                // Actualizamos el total en pantalla
                totalTextView.text = "Total: %.2f€".format(total)
            }
        }

        // Declaro el boton de pagar para redirigirme a la confirmación de pago
        val botonPago: Button = findViewById(R.id.pago)

        // Accion que se hace cuando el usuario ya ha elegido lo que quiere y el camarero le da a pagar
        botonPago.setOnClickListener {
            // Creo una lista con los productos y sus cantidades
            val resumenProductos = productosSeleccionados.map { (nombre, cantidad) -> "$nombre x$cantidad" }

            // Creo un intent para ir a la actividad de pago
            val intent = Intent(this, PagoActivity::class.java).apply {
                putExtra("productos", ArrayList(resumenProductos))
                putExtra("total", total)
            }
            startActivity(intent)
        }
    }
}


