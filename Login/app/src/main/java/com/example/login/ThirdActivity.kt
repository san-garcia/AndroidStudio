package com.example.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        /*Botón al registrarse*/
        val botonRegistrar : Button = findViewById(R.id.botonRegistrar)

        /*Acción que hace el usuario al clicar Registrarse*/
        botonRegistrar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}