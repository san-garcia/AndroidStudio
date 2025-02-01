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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_carta)

        // Botón para volver a la pantalla anterior
        val botonAtras: ImageButton = findViewById(R.id.flecha)
        botonAtras.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // TextView donde se mostrará el total
        val totalTextView: TextView = findViewById(R.id.total)

        // Lista de productos con sus precios
        val productos = mapOf(
            R.id.sushi1 to 5.0,
            R.id.sushi2 to 6.0,
            R.id.sushi3 to 4.5,
            R.id.sushi4 to 7.0,
            R.id.sushi5 to 5.5,
            R.id.sushi6 to 6.5,
            R.id.sushi7 to 8.0,
            R.id.sushi8 to 7.5,
            R.id.poke1 to 9.0,
            R.id.poke2 to 10.0,
            R.id.poke3 to 8.5,
            R.id.poke4 to 11.0,
            R.id.poke5 to 9.5,
            R.id.poke6 to 10.5,
            R.id.poke7 to 12.0,
            R.id.poke8 to 11.5,
            R.id.especial1 to 13.0,
            R.id.especial2 to 14.0,
            R.id.especial3 to 12.5,
            R.id.especial4 to 15.0,
            R.id.especial5 to 14.5,
            R.id.especial6 to 16.0
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
        val botonPago: Button = findViewById(R.id.pago)

        /*Accion que se hace cuando el usuario ya ha elegido lo que quiere y el camarero le da a pagar*/
        botonPago.setOnClickListener {
            val productosSeleccionados = mutableListOf<String>()
            for ((id, _) in productos) {
                val producto = findViewById<ImageButton>(id)
                // Aquí añadimos la lógica para ver si el producto fue seleccionado.
                if (producto.isPressed) {
                    productosSeleccionados.add("Producto $id")  // O usa el nombre del producto
                }
            }

            // Crear el Intent y pasar los productos seleccionados
            val intent = Intent(this, PagoActivity::class.java).apply {
                putExtra("productos", ArrayList(productosSeleccionados))  // Asegúrate de pasar el ArrayList correctamente
                putExtra("total", total)
            }
            startActivity(intent)




        }
    }
}
