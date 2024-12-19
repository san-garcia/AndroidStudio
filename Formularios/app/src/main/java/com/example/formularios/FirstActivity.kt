package com.example.formularios

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class FirstActivity : AppCompatActivity() {
    // Creo una referencia a la base de datos
    private lateinit var base_firebase: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        // Inicializo la referencia creada
        base_firebase = FirebaseDatabase.getInstance().reference

        /*Cajas de texto*/
        val cajaTipo : EditText = findViewById(R.id.cajaTipo)
        val cajaLugar : EditText = findViewById(R.id.cajaLugar)
        val cajaSalario : EditText = findViewById(R.id.cajaSalario)

        /*Botones busco empleo e inicio*/
        val botonBuscar : Button = findViewById(R.id.botonBuscar)
        val botonInicio : Button = findViewById(R.id.botonInicio)

        /*Accion que hace el usuario al clicar el boton buscar*/
        botonBuscar.setOnClickListener {
            val tipo = cajaTipo.text.toString()
            val lugar = cajaLugar.text.toString()
            val salario = cajaSalario.text.toString()

            if(tipo.isNotEmpty()&&lugar.isNotEmpty()&&salario.isNotEmpty()) {
                // Añadir una alerta
                val datos = mapOf(
                    "tipo" to tipo,
                    "lugar" to lugar,
                    "salario" to salario
                )
                base_firebase.child("interesados").push().setValue(datos)
                    .addOnSuccessListener {
                        Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show()
                        // Limpiamos el teclado
                        cajaTipo.text.clear()
                        cajaLugar.text.clear()
                        cajaSalario.text.clear()
                    }
                    .addOnFailureListener { error ->
                        Toast.makeText(this, "Error al insertar: ${error.message}", Toast.LENGTH_SHORT).show()
                    }
            } else {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }



        /*Accion que hace el usuario al clicar al boton inicio*/
        botonInicio.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}