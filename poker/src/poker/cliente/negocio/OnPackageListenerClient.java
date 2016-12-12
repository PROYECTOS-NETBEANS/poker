package poker.cliente.negocio;

import java.util.EventListener;
import poker.servidor.datos.Jugador;
import poker.servidor.negocio.Mesa;

/**
 * Interface escuchador para los eventos
 * cuando llegan los paquetes del servidor.
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public interface OnPackageListenerClient extends EventListener{
    /**
     * Mesa nueva que llega del servidor
     * @param mesa 
     */
    public void onNuevaMesa(Mesa mesa);
    /**
     * Cambia el estado de la mesa 
     * @param idMesa Identificador primario de mesa que se cambiará el estado
     * @param estado Estado [true : mesa llena, false mesa vacia]
     */
    public void onMesaLlena(int idMesa, boolean estado);
    /**
     * Cuando un jugador nuevo entra al servidor
     * @param jg Jugador que llega del servidor
     */
    public void onNuevoJugador(Jugador jg);
    /**
     * Metodo que se desencadena cuando ingresa
     * un jugador a una mesa
     * @param jg Jugador que ingresa a la mesa
     * @param idMesa Identificador de mesa
     */
    public void onJugadorIngresaAMesa(Jugador jg, Mesa m);
    /**
     * Metodo que se desencadena cuando llega un jugador a eliminar
     * @param jg Jugador a eliminar
     */
    public void onJugadorDesconectado(Jugador jg);
}