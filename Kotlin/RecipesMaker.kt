/*
 * Basic Kotlin example. Recipes Maker application with standard console input and output
 * @author J. Alvarez
 */

fun makeRecipe() {
    val ingredientes: List<String> = listOf("Agua", "Leche", "Carne", "Verduras", "Frutas", "Cereal", "Huevos", "Aceite", "Guardar y Salir")

    println("Hacer receta\nSelecciona por categoría el ingrediente que buscas")

    for ((indice, ingrediente) in ingredientes.withIndex())
        println("${indice + 1}. $ingrediente")
}

fun viewRecipe(opcion: Int, opciones: List<String>) {
    println("${opciones[opcion]}\n")
}

fun main() {
    val ingredientes: List<String> = listOf("Agua", "Leche", "Carne", "Verduras", "Frutas", "Cereal", "Huevos", "Aceite", "Guardar y Salir")
    val opciones: List<String> = listOf("Hacer una receta", "Ver mis recetas", "Salir")
    val cabecera: String = """:: Bienvenido a Recipe Maker ::
        |Selecciona la opción deseada
        |1. ${opciones[0]}
        |2. ${opciones[1]}
        |3. ${opciones[2]}
    """.trimMargin()

    var recetas: MutableList<MutableList<String>> = mutableListOf()
    var ingredienteNuevo: Int?
    var programaTerminado = false

    do {
        println(cabecera)
        var recetaActual: MutableList<String> = mutableListOf<String>()
        var agregandoIngredientes = true

        try {
            var seleccion: Int = readLine()?.toInt() ?: 0
            viewRecipe(seleccion-1, opciones)

            when (seleccion) {
                1 -> {
                    do {
                        println("Por favor selecciona un ingrediente para agregar a la receta: $agregandoIngredientes")
                        for ((indice, ingrediente) in ingredientes.withIndex())
                            println("${indice + 1}. $ingrediente")

                        ingredienteNuevo = readLine()?.toInt()?.minus(1) ?: -1

                        if (ingredienteNuevo.compareTo(0) < 0 || ingredienteNuevo.compareTo(ingredientes.size) >= 0)
                            println("Opción no válida")
                        else {
                            when (ingredienteNuevo) {
                                in 0..ingredientes.size.minus(2) -> {
                                    recetaActual.add(ingredientes.get(ingredienteNuevo))
                                    println("Agregado\n")
                                }
                                ingredientes.size.minus(1) -> {
                                    recetas.add(recetaActual)
                                    agregandoIngredientes = false
                                    println("Se ha guardado la receta\n")
                                }
                            }
                        }
                    } while (agregandoIngredientes)
                }
                2 -> {
                    println("Estas son tus recetas: ")

                    for ((indiceReceta, receta) in recetas.withIndex()) {
                        print("${indiceReceta + 1}. ")
                        for (ingrediente in receta)
                            print("$ingrediente ")
                        print("\n")
                    }
                    print("\n")
                }
                3 -> {
                    println("Fin del programa")
                    programaTerminado = true
                }
                else -> {
                    println("Por favor ingresa una opción válida")
                }
            }
        }
        catch (e: NumberFormatException) {
            println("Solo se permite ingresar numeros!!\n\n")
        }
    } while(programaTerminado.not())
}