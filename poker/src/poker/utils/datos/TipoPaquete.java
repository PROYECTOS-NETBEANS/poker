package poker.utils.datos;

/**
 *
 * @author LIMBERT
 */
public enum TipoPaquete {
    MESA,
    JUGADOR,
    
    JUGADOR_DESCONECTADO,    
    PAQUETE_VACIO,
    // es un paquete con el id de la mesa a donde uno ingresa para enviar al cliente
    // Tambien se usa para esperar la respuesta del servidor , devuelve un jugador y mesa donde ingreso
    INGRESAR_A_MESA
}