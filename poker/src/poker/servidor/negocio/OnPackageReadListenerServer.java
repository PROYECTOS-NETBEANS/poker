
package poker.servidor.negocio;

import java.util.EventListener;

/**
 * Metodo que encargado de interpretar los mensajes que llegan de los clientes
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public interface OnPackageReadListenerServer extends EventListener{
    
    /**
     * Metodo que se genera cuando llega un mensaje del cliente
     * @param idMesa Identificador de mesa
     * @param idJugador Identificador unico de jugador
     */
    public void onIngresarMesa(int idMesa, int idJugador);
    
}
