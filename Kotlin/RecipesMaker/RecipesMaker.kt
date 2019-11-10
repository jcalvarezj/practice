import model.*
/*
 * Basic Kotlin example. Recipes Maker application with standard console input and output
 * @author J. Alvarez
 */

fun makeRecipe(categorias: List<Ingrediente>) {
    println("Hacer receta\nSelecciona por categoría el ingrediente que buscas")

    for ((indice, categoria) in categorias.withIndex())
        println("${indice + 1}. ${categoria.nombre}")
    println("${categorias.size + 1}. Guardar receta y volver al menú principal")
}

fun expandCategory(categorias: List<Ingrediente>, seleccion: Int): List<String> {
    val ingredientes: List<String> = categorias.get(seleccion).obtenerListaPorCategoria()
    println("Hacer receta\n" + "Selecciona los ingrediente que buscas")

    for ((indice, ingrediente) in ingredientes.withIndex())
        println("${indice + 1}. $ingrediente")
    println("${ingredientes.size + 1}. Guardar y Volver a Categorías")

    return ingredientes
}

fun viewRecipe(opcion: Int, opciones: List<String>) {
    println("${opciones[opcion]}\n")
}

fun userInput(): Int {
    return readLine()?.toInt()?.minus(1) ?: -1
}

fun main() {
    val categorias: List<Ingrediente> = listOf(Agua("Agua"), Lacteo("Lacteos"), Carne("Carnes"),
        Verdura("Verduras"), Fruta("Frutas"), Cereal("Cereales"), Huevo("Huevos"), Aceite("Aceites"))

    val opciones: List<String> = listOf("Hacer una receta", "Ver mis recetas", "Salir")
    val cabecera: String = """:: Bienvenido a Recipe Maker ::
        |Selecciona la opción deseada
        |1. ${opciones[0]}
        |2. ${opciones[1]}
        |3. ${opciones[2]}
    """.trimMargin()

    var recetas: MutableList<Receta> = mutableListOf()
    var seleccionCategoria: Int?
    var seleccionIngrediente: Int?
    var programaTerminado: Boolean = false

    do {
        println(cabecera)
        var recetaActual: Receta = Receta()
        var navegandoCategorias: Boolean = true

        try {
            val seleccionPrincipal: Int = userInput()

            if(seleccionPrincipal.compareTo(0) < 0 || seleccionPrincipal.compareTo(2) > 0)
                println("Opción no válida")
            else
                viewRecipe(seleccionPrincipal, opciones)

            when (seleccionPrincipal) {
                0 -> {
                    do {
                        var agregandoIngredientes: Boolean = true

                        makeRecipe(categorias)
                        seleccionCategoria = userInput()

                        if (seleccionCategoria.compareTo(0) < 0 || seleccionCategoria.compareTo(categorias.size) > 0)
                            println("Opción no válida\n")
                        else {
                            when (seleccionCategoria) {
                                in 0..categorias.size.minus(1) -> {

                                    do {
                                        val ingredientesCategoria: List<String> = expandCategory(categorias, seleccionCategoria)
                                        seleccionIngrediente = userInput()

                                        val ultimoIndiceIngredientes: Int = ingredientesCategoria.size.minus(1)

                                        if (seleccionIngrediente.compareTo(0) < 0 || seleccionIngrediente.compareTo(ingredientesCategoria.size) > 0)
                                            println("Opción no válida\n")
                                        else {
                                            when(seleccionIngrediente) {
                                                in 0..ultimoIndiceIngredientes -> {
                                                    recetaActual.ingredientes.add(ingredientesCategoria.get(seleccionIngrediente))
                                                    println("Agregado... \n" + "Receta actual: ${recetaActual.ingredientes}")
                                                }
                                                ingredientesCategoria.size -> {
                                                    agregandoIngredientes = false
                                                    println("Se han guardado los ingredientes en la receta actual... \nReceta actual: ${recetaActual.ingredientes}\n\n")
                                                }
                                            }
                                        }

                                    } while (agregandoIngredientes)

                                }
                                categorias.size -> {
                                    recetas.add(recetaActual)
                                    navegandoCategorias = false
                                    println("Se ha guardado la receta: ${recetaActual.ingredientes}\n")
                                }
                            }
                        }
                    } while (navegandoCategorias)
                }
                1 -> {
                    println("Estas son tus recetas: ")

                    for ((indiceReceta, receta) in recetas.withIndex()) {
                        print("${indiceReceta + 1}. ")
                        for (ingrediente in receta.ingredientes)
                            print("- $ingrediente - ")
                        print("\n")
                    }
                    print("\n")
                }
                2 -> {
                    println("Fin del programa")
                    programaTerminado = true
                }
                else -> {
                    println("Por favor ingresa una opción válida")
                }
            }
        }
        catch (e: NumberFormatException) {
            println("Solo se permite ingresar numeros!!\n")
        }
    } while(programaTerminado.not())
}