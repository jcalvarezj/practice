package model

class Lacteo(nombre: String): Ingrediente(nombre) {
    override fun obtenerListaPorCategoria(): List<String> {
        return listOf("Leche", "Mantequilla", "Yogurt", "Crema", "Queso")
    }
}