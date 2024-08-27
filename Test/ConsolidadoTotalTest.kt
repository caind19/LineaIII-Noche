import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class ConsolidadoTotalTest {

    private lateinit var cabina1: Cabina
    private lateinit var cabina2: Cabina

    @BeforeEach
    fun setUp() {
        cabina1 = Cabina().apply {
            registrarLlamada(TipoLlamada.LOCAL, 10)
            registrarLlamada(TipoLlamada.LARGA_DISTANCIA, 5)
        }
        cabina2 = Cabina().apply {
            registrarLlamada(TipoLlamada.CELULAR, 8)
            registrarLlamada(TipoLlamada.LOCAL, 7)
        }
    }

    @Test
    fun `debería calcular el consolidado total de todas las cabinas`() {
        // Obtener el consolidado total de cada cabina
        val consolidadoCabina1 = cabina1.obtenerConsolidadoTotal()
        val consolidadoCabina2 = cabina2.obtenerConsolidadoTotal()

        // Consolidar total
        val consolidadoTotal = consolidadoCabina1.sumar(consolidadoCabina2)

        // Calcular valores esperados
        val costoTotalEsperado = consolidadoCabina1.costoTotal + consolidadoCabina2.costoTotal
        val numeroTotalLlamadasEsperado = consolidadoCabina1.numeroTotalLlamadas + consolidadoCabina2.numeroTotalLlamadas
        val duracionTotalEsperado = consolidadoCabina1.duracionTotal + consolidadoCabina2.duracionTotal
        val costoPromedioPorMinutoEsperado = if (duracionTotalEsperado > 0) costoTotalEsperado / duracionTotalEsperado else 0.0

        // Verificar los resultados
        assertEquals(costoTotalEsperado, consolidadoTotal.costoTotal, 0.01)
        assertEquals(numeroTotalLlamadasEsperado, consolidadoTotal.numeroTotalLlamadas)
        assertEquals(duracionTotalEsperado, consolidadoTotal.duracionTotal)
        assertEquals(costoPromedioPorMinutoEsperado, consolidadoTotal.costoPromedioPorMinuto, 0.01)
    }
}
