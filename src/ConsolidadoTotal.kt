data class ConsolidadoTotal(
    val costoTotal: Double = 0.0,
    val numeroTotalLlamadas: Int = 0,
    val duracionTotal: Int = 0
) {
    fun sumar(other: ConsolidadoTotal): ConsolidadoTotal {
        return ConsolidadoTotal(
            costoTotal + other.costoTotal,
            numeroTotalLlamadas + other.numeroTotalLlamadas,
            duracionTotal + other.duracionTotal
        )
    }

    val costoPromedioPorMinuto: Double
        get() = if (duracionTotal > 0) costoTotal / duracionTotal else 0.0
}