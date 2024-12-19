package com.example.login

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.appcompat.app.AlertDialog
import android.content.Intent
import android.widget.EditText
import com.example.login.R

class MainActivity : AppCompatActivity() {
    /*Usuario y contraseña ya definidos*/
    private val user = "alejandro.palacios"
    private val contraseña = "aulacampus2024"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /*Texto y cajas de texto*/
        val textViewUsuario : TextView = findViewById(R.id.textViewUsuario)
        val cajaUsuario : EditText = findViewById(R.id.cajaUsuario)
        val textViewContraseña : TextView = findViewById(R.id.textViewContraseña)
        val cajaContraseña : TextView = findViewById(R.id.cajaContraseña)

        /*Botón de iniciar sesion*/
        val botonLogin : Button = findViewById(R.id.botonLogin)

        /*Botón al dar a registrar*/
        val botonRegistrar : Button = findViewById(R.id.botonRegistrar)

        /*Acción que hace el usuario al clicar Iniciar Sesión*/
        botonLogin.setOnClickListener {
            val insertarUsuario = cajaUsuario.text.toString()
            val insertarContraseña = cajaContraseña.text.toString()

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
                        val intent = Intent(this, SecondActivity::class.java)
                        startActivity(intent)
                    } else {
                        showAlert()
                    }
                }
            }
        }

        /*Accion que hago al clicar Registrar*/
        botonRegistrar.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
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