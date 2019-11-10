package model

class Huevo(nombre: String): Ingrediente(nombre) {
    override fun obtenerListaPorCategoria(): List<String> {
        return listOf("Huevo de Gallina", "Huevo de Codorniz")
    }
}