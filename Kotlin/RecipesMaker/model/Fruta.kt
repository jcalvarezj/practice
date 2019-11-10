package model

class Fruta(nombre: String): Ingrediente(nombre) {
    override fun obtenerListaPorCategoria(): List<String> {
        return listOf("Fresa", "Plátano", "Uvas", "Manzana", "Naranja", "Pera", "Cereza")
    }
}