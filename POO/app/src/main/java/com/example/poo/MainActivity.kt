package com.example.poo

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.content.ContextCompat
import android.graphics.Color
import android.util.Log
import android.view.View


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main) // Lo que hace es hacer referencia a la ventana que vamos a trabajar que es la main
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /* Cambiar texto título y subtítulo */
        val textViewTitulo: TextView = findViewById(R.id.textViewTitulo)
        val textViewSubTitulo: TextView = findViewById(R.id.textViewNombre)
        val botonCambiarTexto: Button = findViewById(R.id.botonCambiarTexto)

        botonCambiarTexto.setOnClickListener {
            textViewTitulo.text = "Corazones Callejeros Valencia"
            textViewSubTitulo.text ="Organización sin ánimo de lucro en Valencia dedicada a encontrar hogares amorosos para animales rescatados"
        }

        /* Cambiar imagen y texto al presionar el botón 'Conoce Peludito' */
        val botonConocePeludito: Button = findViewById(R.id.botonCambiarImagen)
        val imageView: ImageView = findViewById(R.id.textoTitulo)

        botonConocePeludito.setOnClickListener {
            textViewTitulo.text = "Mango"
            textViewSubTitulo.text = "Es un pug lleno de energía y alegría, con una personalidad tan dulce como su nombre. Siempre curioso y juguetón, le encanta hacer reír con su carita tierna y su actitud traviesa. Un compañero fiel que llena de amor cada rincón de tu hogar."

            textViewTitulo.visibility = View.VISIBLE
            textViewSubTitulo.visibility = View.VISIBLE

            imageView.setImageResource(R.drawable.perro2)
        }

        /* Cambiar color a los botones */
        val botonCambiarColor: Button = findViewById(R.id.botonCambiarColor)
        val botonCambiarText: Button = findViewById(R.id.botonCambiarTexto)
        val botonCambiarImagen: Button = findViewById(R.id.botonCambiarImagen)

        botonCambiarColor.setOnClickListener {
            botonCambiarText.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.colorBotonNuevo
                )
            )
            botonCambiarImagen.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.colorBotonNuevo
                )
            )
            botonCambiarColor.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.colorBotonNuevo
                )
            )
        }
    }
}