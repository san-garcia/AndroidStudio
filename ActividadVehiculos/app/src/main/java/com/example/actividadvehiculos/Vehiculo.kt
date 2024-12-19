package com.example.actividadvehiculos

open class Vehiculo ( // Ponemos open para que se pueda anidar
    // Atributos
    private var marca: String,
    private var modelo: String,
    private var color: String,
    private var motor: String,
    private var matricula: String
    ) {

    // Getters y setters
    fun getMarca(): String {return this.marca}
    fun getModelo(): String {return this.modelo}
    fun getColor(): String {return this.color}
    fun getMotor(): String {return this.motor}
    fun getMatricula(): String {return this.matricula}

    fun setMarca(marca: String) {this.marca = marca}
    fun setModelo(modelo: String) {this.modelo = modelo}
    fun setColor(color: String) {this.color = color}
    fun setMotor(motor: String) {this.motor = motor}
    fun setMatricula(matricula: String) {this.matricula = matricula}


}