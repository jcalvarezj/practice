package model

class Verdura(nombre: String): Ingrediente(nombre) {
    override fun obtenerListaPorCategoria(): List<String> {
        return listOf("Zanahoria", "Coliflor", "Espinaca", "Lechuga", "Remolacha", "Apio", "Cebolla")
    }
}