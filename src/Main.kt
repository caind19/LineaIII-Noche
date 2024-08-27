import java.util.InputMismatchException
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val cabinas = mutableMapOf<Int, Cabina>()
    var cabinaActual: Cabina? = null
    var idCabinaActual: Int? = null

    while (true) {
        try {
            println("*** Gestor de Gastos Telefónicos ***")
            println("0. Crear Cabinas")
            println("1. Seleccionar Cabina")
            println("2. Registrar Llamada")
            println("3. Mostrar Información")
            println("4. Mostrar Consolidado De Todas Las Cabinas")
            println("5. Mostrar Consolidado De Una Cabina")
            println("6. Reiniciar Una De Las Cabinas")
            println("7. Reiniciar Todas Las Cabinas")
            println("8. Salir")
            print("Seleccione una opción:>> ")

            when (scanner.nextInt()) {
                0 -> {
                    print("¿Cuántas cabinas desea crear? ")
                    val cantidad = scanner.nextInt()
                    if (cantidad <= 0) {
                        println("La cantidad de cabinas debe ser mayor que 0.")
                        continue
                    }
                    val idInicio = cabinas.size + 1
                    for (i in 0 until cantidad) {
                        val nuevaId = idInicio + i
                        cabinas[nuevaId] = Cabina()
                        println("Nueva cabina creada con ID: $nuevaId")
                    }
                }
                1 -> {
                    println("Ingrese el ID de la cabina a seleccionar:")
                    val id = scanner.nextInt()
                    cabinaActual = cabinas[id]
                    idCabinaActual = id
                    if (cabinaActual != null) {
                        println("Cabina $id seleccionada.")
                    } else {
                        println("ID de cabina no válido.")
                    }
                }
                2 -> {
                    if (cabinaActual == null) {
                        println("Primero seleccione una cabina.")
                        continue
                    }
                    println("Seleccione el tipo de llamada (1 para LOCAL, " +
                            "2 para LARGA DISTANCIA, 3 para CELULAR):")
                    val tipoSeleccionado = scanner.nextInt()
                    val tipo = when (tipoSeleccionado) {
                        1 -> TipoLlamada.LOCAL
                        2 -> TipoLlamada.LARGA_DISTANCIA
                        3 -> TipoLlamada.CELULAR
                        else -> {
                            println("Tipo de llamada no válido.")
                            continue
                        }
                    }
                    print("Ingrese la duración en minutos: ")
                    val duracion = scanner.nextInt()
                    cabinaActual!!.registrarLlamada(tipo, duracion)
                    println("Llamada registrada exitosamente en la cabina $idCabinaActual.")
                }
                3 -> {
                    if (cabinaActual == null) {
                        println("Primero seleccione una cabina.")
                        continue
                    }
                    println("Información de la cabina $idCabinaActual:" +
                            "\n${cabinaActual!!.obtenerInformacion()}")
                }
                4 -> {
                    if (cabinas.isEmpty()) {
                        println("No hay cabinas registradas.")
                        continue
                    }

                    // Mostrar información de cada cabina individualmente
                    val consolidadoTotal = cabinas.entries.fold(ConsolidadoTotal())
                    { acumulador, entry ->
                        val idCabina = entry.key
                        val cabina = entry.value
                        val consolidadoCabina = cabina.obtenerConsolidadoTotal()

                        println("Consolidado de la cabina $idCabina:")
                        println("  Costo Total: ${consolidadoCabina.costoTotal}")
                        println("  Número Total de Llamadas: " +
                                "${consolidadoCabina.numeroTotalLlamadas}")
                        println("  Duración Total de Llamadas (Minutos): " +
                                "${consolidadoCabina.duracionTotal}")
                        println("  Costo Promedio por Minuto: " +
                                "${consolidadoCabina.costoPromedioPorMinuto}")
                        println()

                        // Sumar el consolidado de la cabina actual al total
                        acumulador.sumar(consolidadoCabina)
                    }

                    // Mostrar consolidado total de todas las cabinas
                    println("Consolidado total de todas las cabinas:")
                    println("Costo Total: ${consolidadoTotal.costoTotal}")
                    println("Número Total de Llamadas: " +
                            "${consolidadoTotal.numeroTotalLlamadas}")
                    println("Duración Total de Llamadas (Minutos): " +
                            "${consolidadoTotal.duracionTotal}")
                    println("Costo Promedio por Minuto: " +
                            "${consolidadoTotal.costoPromedioPorMinuto}")
                }
                5 -> {
                    println("Ingrese el ID de la cabina para mostrar consolidado:")
                    val id = scanner.nextInt()
                    val cabina = cabinas[id]
                    if (cabina == null) {
                        println("ID de cabina no válido.")
                        continue
                    }
                    val consolidado = cabina.obtenerConsolidadoTotal()
                    println("Consolidado total de la cabina $id:")
                    println("Costo Total: ${consolidado.costoTotal}")
                    println("Número Total de Llamadas: " +
                            "${consolidado.numeroTotalLlamadas}")
                    println("Duración Total de Llamadas (Minutos): " +
                            "${consolidado.duracionTotal}")
                    println("Costo Promedio por Minuto: " +
                            "${consolidado.costoPromedioPorMinuto}")
                }
                6 -> {
                    if (cabinaActual == null) {
                        println("Primero seleccione una cabina para reiniciar.")
                        continue
                    }
                    cabinaActual!!.reiniciar()
                    println("Cabina $idCabinaActual reiniciada.")
                }
                7 -> {
                    cabinas.forEach { (id, cabina) ->
                        cabina.reiniciar()
                        println("Cabina $id reiniciada.")
                    }
                }
                8 -> {
                    println("Saliendo...")
                    break
                }
                else -> {
                    println("Opción no válida. Inténte de nuevo.")
                }
            }
        } catch (e: InputMismatchException) {
            println("Entrada no válida. Ingrese un número.")
            scanner.nextLine() // Limpiar el buffer de entrada
        } catch (e: Exception) {
            println("Se produjo un error no esperado: ${e.message}")
        }
    }
}
