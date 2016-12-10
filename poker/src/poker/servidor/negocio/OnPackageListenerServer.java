
package poker.servidor.negocio;

import java.util.EventListener;

/**
 * 
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public interface OnPackageListenerServer extends EventListener{
    
    /**
     * Metodo que envia el id de la mesa donde va ingresar
     * @param idMesa Identificador de mesa
     * @param idJugador Identificador unico de jugador
     */
    public void onIngresarMesa(int idMesa, int idJugador);
    
}
