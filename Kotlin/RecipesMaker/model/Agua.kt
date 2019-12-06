package model

class Agua(nombre: String): Ingrediente(nombre) {
    override fun obtenerListaPorCategoria(): List<String> {
        return listOf("Agua")
    }

}