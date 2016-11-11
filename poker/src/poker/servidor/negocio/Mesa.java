package poker.servidor.negocio;

import java.util.LinkedList;

/**
 * 
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class Mesa {

    private Baraja baraja = null;
    private LinkedList<Jugador> jugadores = null;
    /**
     * True si la mesa esta vacia false cuando este llena
     */
    private boolean estado = true;
    /**
     * Nro maximo de jugadores
     */
    private int nroMax = 0;
    
    public Mesa(){
        this.jugadores = new LinkedList<>();
        this.baraja = new Baraja();
        this.estado = true;
        this.nroMax = 0;
    }
    
}
