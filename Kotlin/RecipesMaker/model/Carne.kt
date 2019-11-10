package model

class Carne(nombre: String): Ingrediente(nombre) {
    override fun obtenerListaPorCategoria(): List<String> {
        return listOf("Res", "Pollo", "Cerdo", "Pescado")
    }
}