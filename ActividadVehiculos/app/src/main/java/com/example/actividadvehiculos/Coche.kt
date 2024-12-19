package com.example.actividadvehiculos

class Coche (
    // Atributos
    marca: String,
    modelo: String,
    color: String,
    motor: String,
    matricula: String,

    // Ponemos los atributos privados especificos para el coche
    private var puertas : Int

    ) : Vehiculo(marca,modelo,color,motor,matricula) {
    // Gett y sett de Coche
    fun getPuertas(): Int {return this.puertas}
    fun setPuertas(puertas: Int) {this.puertas = puertas}

}