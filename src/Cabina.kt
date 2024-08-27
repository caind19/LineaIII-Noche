data class Cabina(
    private var llamadas: MutableList<Pair<TipoLlamada, Int>> = mutableListOf()
) {
    fun registrarLlamada(tipo: TipoLlamada, duracion: Int) {
        llamadas.add(Pair(tipo, duracion))
    }

    fun obtenerInformacion(): String {
        val numLlamadas = llamadas.size
        val duracionTotal = llamadas.sumOf { it.second }
        val costoTotal = llamadas.sumOf { it.first.costo * it.second }
        return "Número de llamadas: $numLlamadas\nDuración total: $duracionTotal " +
                "minutos\nCosto total: $costoTotal pesos"
    }

    fun obtenerConsolidadoTotal(): ConsolidadoTotal {
        val numLlamadas = llamadas.size
        val duracionTotal = llamadas.sumOf { it.second }
        val costoTotal = llamadas.sumOf { it.first.costo * it.second }
        return ConsolidadoTotal(costoTotal, numLlamadas, duracionTotal)
    }

    fun reiniciar() {
        llamadas.clear()
    }
}
enum class TipoLlamada(val costo: Double) {
    LOCAL(50.0),
    LARGA_DISTANCIA(350.0),
    CELULAR(150.0)
}