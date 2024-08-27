# Gestor de Gastos Telefónicos

## Descripción

Gestiona el registro y consolidado de llamadas telefónicas desde diferentes cabinas. Permite crear cabinas, seleccionar cabinas, registrar llamadas, y generar informes de costos, cantidad y duración en las llamadas.

## Explicación breve del Funcionamiento:

### Inicio del Programa

Ejecuta `main.kt` para iniciar el programa y seguir el menú de opciones en la consola.

### Opciones del Menú

1. **Crear Cabina**: Crea nuevas cabinas.
2. **Seleccionar Cabina**: Selecciona una cabina para operar.
3. **Registrar Llamada**: Registra una llamada en la cabina seleccionada.
4. **Mostrar Información**: Muestra detalles de la cabina seleccionada.
5. **Mostrar Consolidado De Todas Las Cabinas**: Resumen de todas las cabinas.
6. **Mostrar Consolidado De Una Cabina**: Resumen de una cabina específica.
7. **Reiniciar Una Cabina**: Borra todas las llamadas de la cabina seleccionada.
8. **Reiniciar Todas Las Cabinas**: Borra todas las llamadas de todas las cabinas.
9. **Salir**: Cierra el programa.

### Manejo de Errores:

- **Entrada Inválida**: Notifica y limpia el buffer si se ingresa un valor no numérico.
- **ID de Cabina No Válido**: Notifica si el ID de la cabina no existe.

## Mejoras y Nuevas Funcionalidades:

- **Persistencia de Datos**: Guardar datos en archivo o base de datos.
- **Interfaz de Usuario**: Desarrollar una GUI.
- **Validación Adicional**: Mejorar validaciones de entrada.
- **Manejo Avanzado de Errores**: Añadir registro de errores.
- **Historial de Llamadas**: Consultar historial de llamadas.
- **Reporte de Costos Detallado**: Generar reportes detallados de costos.
- **Notificaciones y Alertas**: Agregar alertas para eventos importantes.
- **Autenticación y Seguridad**: Implementar autenticación de usuario.
