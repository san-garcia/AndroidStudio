package com.example.examen

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.*
import androidx.core.view.*

class MainActivity : AppCompatActivity() {
    /*Declaro el nombre del usuario y su contraseña*/
    private val user = "sangarfa@campusaula.com"
    private val pswd = "1111"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /*Declaro los textos y las cajas de texto*/
        val textViewUsuario : TextView = findViewById(R.id.textViewUsuario)
        val cajaUsuario : EditText = findViewById(R.id.cajaUsuario)
        val textViewContraseña : TextView = findViewById(R.id.textViewContraseña)
        val cajaContraseña : TextView = findViewById(R.id.cajaContraseña)

        /*Delcaro el boton de iniciar sesion*/
        val botonLogin : Button = findViewById(R.id.botonLogin)

        /*Acción que hace el usuario al clicar Iniciar Sesión*/
        botonLogin.setOnClickListener {
            val insertarUsuario = cajaUsuario.text.toString()
            val insertarContraseña = cajaContraseña.text.toString()

            /*Validamos si el usuario escribe el usuario y contraseña*/
            if (insertarUsuario.isEmpty() || insertarContraseña.isEmpty()) {
                alertVacio()
            } else {
                /*Validamos si el usuario ha escrito bien su usario o su contraseña*/
                if (insertarUsuario != user || insertarContraseña != pswd) {
                    alertIncorrecto()
                } else {
                    /*Validamos que el ususario sea el correcto*/
                    if (insertarUsuario == user && insertarContraseña == pswd) {
                        val intent = Intent(this, SecondActivity::class.java)
                        startActivity(intent)
                    } else {
                        showAlert()
                    }
                }
            }
        }

    }

    /*Alertas al realizar dicha acción*/
    private fun showAlert() {
        val alerta = AlertDialog.Builder(this)
        alerta.setTitle("ERROR AL INICIAR SESIÓN")
        alerta.setMessage("Incorrecto el usuario o contraseña, vuelva a intentarlo")
        alerta.setPositiveButton("Aceptar") { dialog, _ -> dialog.dismiss() }
        alerta.setNegativeButton("Cancelar") { dialog, _ -> dialog.dismiss() }
        val dialog = alerta.create()
        dialog.show()
    }

    private fun alertIncorrecto() {
        val alerta = AlertDialog.Builder(this)
        alerta.setTitle("Usuario o contraseña incorrectos")
        alerta.setMessage("Vuelva a rellenar los campos correctamente")
        alerta.setPositiveButton("Aceptar") { dialog, _ -> dialog.dismiss() }
        alerta.setNegativeButton("Cancelar") { dialog, _ -> dialog.dismiss() }
        val dialog = alerta.create()
        dialog.show()
    }

    private fun alertVacio() {
        val alerta = AlertDialog.Builder(this)
        alerta.setTitle("Error")
        alerta.setMessage("Rellene los campos para iniciar sesion")
        alerta.setPositiveButton("Aceptar") { dialog, _ -> dialog.dismiss() }
        alerta.setNegativeButton("Cancelar") { dialog, _ -> dialog.dismiss() }
        val dialog = alerta.create()
        dialog.show()
    }
}