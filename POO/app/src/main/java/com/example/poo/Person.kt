package com.example.poo

class Person(private var nombre: String = "Anonimo", private var pasaporte: String? = null) {
    var alive: Boolean = true

    // Método para "morir"
    fun die() {
        alive = false
    }

    // Getters
    fun getName(): String {
        return this.nombre
    }

    fun getPasaporte(): String? {
        return this.pasaporte
    }

    // Setters
    fun setName(nombre: String) {
        this.nombre = nombre
    }

    fun setPasaporte(pasaporte: String?) {
        this.pasaporte = pasaporte
    }
}
