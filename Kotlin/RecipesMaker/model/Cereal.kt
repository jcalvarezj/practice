package model

class Cereal(nombre: String): Ingrediente(nombre) {
    override fun obtenerListaPorCategoria(): List<String> {
        return listOf("Avena", "Trigo", "Arroz", "Maiz")
    }
}