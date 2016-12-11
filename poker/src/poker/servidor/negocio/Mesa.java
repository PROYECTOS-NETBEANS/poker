package poker.servidor.negocio;

import java.util.HashMap;
import poker.servidor.datos.*;
/**
 * 
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class Mesa {
    
    private int id = 0;
    private Baraja baraja = null;
    private Casa house = null;
    private int apuestaMin = 0;
    /**
     * Es la lista que contiene las cartas de los jugadores en la mesa
     * key : Es el identificador unico del jugador
     * value : Es una lista con las cartas del jugador
     */
    private HashMap<Integer,Object> cartasJugadores = null;
    private HashMap<Integer, Jugador> jugadores = null;
    /**
     * True si la mesa esta vacia false cuando este llena
     */
    private boolean estado = true;
    /**
     * Nro maximo de jugadores
     */
    private int nroMax = 0;
    
    /**
     * Inicializacion con la configuraciones iniciales
     * @param id Identificador unico de mesa
     * @param nroMax Numero maximo que jugadores aceptados en la mesa
     * @param apuestaMin Es el monto minimo que se debe de apostar
     */
    public Mesa(int id, int nroMax, int apuestaMin){
        this.jugadores = new HashMap<>();
        this.baraja = new Baraja();
        this.house = new Casa();
        this.id = id;
        
        this.estado = true;
        this.nroMax = nroMax;
        this.apuestaMin = apuestaMin;
        this.cartasJugadores = new HashMap<>();
    }
    /**
     * Devuelve identificador unico de la mesa
     * @return Identificador de mesa
     */
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
    /**
     * True si la mesa esta vacia false cuando este llena
     * @return 
     */
    public boolean mesaEstaVacia(){
        return estado;
    }
    /**
     * Metodo que cambia de estado de la mesa de acuerdo
     * @param b Estado de la mesa [true: mesa vacia, false : mesa llena]
     */
    public void setEstadoMesa(boolean b){
        this.estado = b;
    }
    /**
     * Metodo que devuelve una lista de jugadores que estan en la mesa
     * @return HashMap con los jugadores de la mesa
     */
    public HashMap<Integer, Jugador> getJugadores(){
        return this.jugadores;
    }
}