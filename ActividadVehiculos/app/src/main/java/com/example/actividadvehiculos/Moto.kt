package com.example.actividadvehiculos

class Moto (
    // Atributos
    marca: String,
    modelo: String,
    color: String,
    motor: String,
    matricula: String,

    // Ponemos los atributos privados especificos para el coche
    private var manillar : String

    ) : Vehiculo(marca,modelo,color,motor,matricula) {
    // Gett y sett de Moto
    fun getManillar(): String { return this.manillar}
    fun setManillar(manillar: String) {this.manillar = manillar}
}
