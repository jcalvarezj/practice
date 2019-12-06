package model

class Aceite(nombre: String): Ingrediente(nombre) {
    override fun obtenerListaPorCategoria(): List<String> {
        return listOf("Aceite")
    }
}