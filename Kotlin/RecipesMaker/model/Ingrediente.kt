package model

abstract class Ingrediente(val nombre: String) {
    var cantidad: Int = 0
    var unidades: String = ""

    init {
        val liquidos: Array<String> = arrayOf("Agua", "Leche", "Yogurt", "Aceite")
        when(this.javaClass.typeName) {
            in liquidos -> {
                unidades = "mililitros"
            }
            else -> {
                unidades = "gramos"
            }
        }
    }

    abstract fun obtenerListaPorCategoria(): List<String>
}