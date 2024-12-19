package com.example.actividadvehiculos

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Inicializamos coche con sus respectivos datos
        val miCoche = Coche("Mini","Cooper", "Rosa", "Tricilindrico","1234ABC",4)
        val miMoto = Moto("Vespa","Primavera 50", "Azul marino", "50cc","4321ABC","Estandar")

        // Imprimos por consola
        println("Coche:")
        println("Marca: " + miCoche.getMarca())
        println("Modelo: " + miCoche.getModelo())
        println("Color: " + miCoche.getColor())
        println("Motor: " + miCoche.getMotor())
        println("Matricula: " + miCoche.getMatricula())
        println("Puertas: " + miCoche.getPuertas())

        println("**********************************")

        println("Moto:")
        println("Marca: " + miMoto.getMarca())
        println("Modelo: " + miMoto.getModelo())
        println("Color: " + miMoto.getColor())
        println("Motor: " + miMoto.getMotor())
        println("Matricula: " + miMoto.getMatricula())
        println("Manillar: " + miMoto.getManillar())
    }
}