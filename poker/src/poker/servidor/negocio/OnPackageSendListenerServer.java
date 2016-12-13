package poker.servidor.negocio;

import java.util.EventListener;
import poker.servidor.datos.Jugador;

/**
 * Clase que implementa los metodos que se invocaran
 * para enviar mensajes a los clientes
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public interface OnPackageSendListenerServer extends EventListener{
    /**
     *  Metodo que se invoca para enviar la mesa a los clientes
     * @param m Mesa que se enviara a los clientes
     */
    public void onEnviarMesa(Mesa m);
    
    /**
     * Envia el jugador y mesa a donde ingreso
     */
    public void onEnviarJugadorIngresadoAMesa(Jugador j, Mesa m);
    /**
     * Envia un mensaje a la mesa con id de mesa
     * @param message Mensaje que se esta enviando
     * @param idMesa Identificador de mesa
     */
    public void onEnviarMessage(String message, int idMesa);
}
