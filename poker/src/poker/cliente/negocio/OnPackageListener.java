package poker.cliente.negocio;

import java.util.EventListener;

/**
 * Interface escuchador para los eventos
 * cuando llegan los paquetes del servidor.
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public interface OnPackageListener extends EventListener{
    public void listaMesas();
    public void nuevaMesa();
    public void mesaLlena(String data);
    
    public void nuevoJugador(String data);
    
}