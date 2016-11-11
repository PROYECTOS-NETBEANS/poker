package poker.servidor.negocio;

import java.util.HashMap;

/**
 * 
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class Mesa {
    
    private int id = 0;
    private Baraja baraja = null;
    private HashMap<Integer, Jugador> jugadores = null;
    /**
     * True si la mesa esta vacia false cuando este llena
     */
    private boolean estado = true;
    /**
     * Nro maximo de jugadores
     */
    private int nroMax = 0;
    
    public Mesa(int id){
        this.jugadores = new HashMap<>();
        this.baraja = new Baraja();
        this.estado = true;
        this.nroMax = 0;
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    /**
     * metodo que adiciona el jugador a la mesa.
     * @param jg Jugador que ingresa a la mesa
     */
    public void setJugador(Jugador jg){
        this.jugadores.put(jg.getId(), jg);
    }
    
    /**
     * Elimina de la mesa al jugador que se desconectado
     * @param id Identificador de mesa
     */
    public void deleteJugador(int id){
        this.jugadores.remove(id);
        
    }
    /**
     * Verifica si un jugador esta en la mesa
     * @param id Identificador unico de jugador
     * @return True si el jugador esta en la mesa
     */
    public boolean existJugador(int id){
        return jugadores.containsKey(id);
    }
}