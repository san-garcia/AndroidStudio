package com.example.proyectofinal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class Sesion : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sesion)

        val botonAtras : ImageButton = findViewById(R.id.flecha)
        val iniciarSesion : Button = findViewById(R.id.iniciarSesion)
        val cajaUsuario : EditText = findViewById(R.id.cajaUsuario)
        val cajaContrasenya : EditText = findViewById(R.id.cajaContrasenya)
        val user = "admin"
        val contraseña = "admin"

        botonAtras.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }

        /*Acción que hace el usuario al clicar Iniciar Sesión*/
        iniciarSesion.setOnClickListener {
            val insertarUsuario = cajaUsuario.text.toString()
            val insertarContraseña = cajaContrasenya.text.toString()

            /*Validamos si el usuario escribe el usuario y contraseña*/
            if (insertarUsuario.isEmpty() || insertarContraseña.isEmpty()) {
                alertVacio()
            } else {
                /*Validamos si el usuario ha escrito bien su usario o su contraseña*/
                if (insertarUsuario != user || insertarContraseña != contraseña) {
                    alertIncorrecto()
                } else {
                    /*Validamos que el ususario sea el correcto*/
                    if (insertarUsuario == user && insertarContraseña == contraseña) {
                        val intent = Intent(this, Perfil::class.java)
                        startActivity(intent)
                    } else {
                        showAlert()
                    }
                }
            }
        }


    }

    /*Llamada de alerta si no hay campos escritos*/
    private fun alertVacio() {
        val alerta = AlertDialog.Builder(this)
        alerta.setTitle("Error")
        alerta.setMessage("Rellene los campos para iniciar sesion")
        alerta.setPositiveButton("Aceptar") { dialog, _ -> dialog.dismiss() }
        alerta.setNegativeButton("Cancelar") { dialog, _ -> dialog.dismiss() }

        val dialog = alerta.create()
        dialog.show()
    }

    /*Llamada de alerta en el caso que el usuario o contraseña sean incorrectos*/
    private fun alertIncorrecto() {
        val alerta = AlertDialog.Builder(this)
        alerta.setTitle("Usuario o contraseña incorrectos")
        alerta.setMessage("Vuelva a rellenar los campos correctamente")
        alerta.setPositiveButton("Aceptar") { dialog, _ -> dialog.dismiss() }
        alerta.setNegativeButton("Cancelar") { dialog, _ -> dialog.dismiss() }

        val dialog = alerta.create()
        dialog.show()
    }

    /*Llamada de la alerta al conectar el usuario incorrecto*/
    private fun showAlert() {
        val alerta = AlertDialog.Builder(this)
        alerta.setTitle("ERROR AL INICIAR SESIÓN")
        alerta.setMessage("Incorrecto el usuario o contraseña, vuelva a intentarlo")
        alerta.setPositiveButton("Aceptar") { dialog, _ -> dialog.dismiss() }
        alerta.setNegativeButton("Cancelar") { dialog, _ -> dialog.dismiss() }

        val dialog = alerta.create()
        dialog.show()
    }

}