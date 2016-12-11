package poker.servidor.negocio;

import java.util.EventListener;

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
}
