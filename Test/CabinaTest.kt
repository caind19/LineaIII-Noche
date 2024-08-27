import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CabinaTest {

    private lateinit var cabina: Cabina

    @BeforeEach
    fun setUp() {
        cabina = Cabina()
    }

    @Test
    fun `debería registrar una llamada correctamente`() {
        cabina.registrarLlamada(TipoLlamada.LOCAL, 10)
        val info = cabina.obtenerInformacion()

        assertEquals("Número de llamadas: 1\nDuración total: 10 minutos\nCosto total: 500.0 pesos", info)
    }

    @Test
    fun `debería reiniciar correctamente la cabina`() {
        cabina.registrarLlamada(TipoLlamada.LARGA_DISTANCIA, 5)
        cabina.reiniciar()
        val info = cabina.obtenerInformacion()

        assertEquals("Número de llamadas: 0\nDuración total: 0 minutos\nCosto total: 0.0 pesos", info)
    }
}
