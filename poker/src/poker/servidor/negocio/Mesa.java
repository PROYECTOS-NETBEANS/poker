package poker.servidor.negocio;

import java.util.HashMap;
import poker.servidor.datos.*;
/**
 * Clase encargada de todo el negocio que ocurre en la mesa
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class Mesa {
    /**
     * Identificador unico de mesa
     */
    private int id = 0;
    /**
     * Baraja que hay en la mesa
     */
    private Baraja baraja = null;
    private Casa house = null;
    private int apuestaMin = 0;
    /**
     * Es la lista que contiene las manos de cada jugador
     * key : Es el identificador unico del jugador
     * value : Es una lista con las cartas del jugador
     */
    private HashMap<Integer,ManoPoker> manosJugadores = null;
    /**
     * Lista de jugadores que estan en la mesa
     */
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
        this.manosJugadores = new HashMap<>();
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
        try {
            this.jugadores.put(jg.getId(), jg);
        } catch (Exception e) {
            System.out.println("[Mesa.setJugador]" + e.getMessage());
        }        
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
    /**
     * Metodo ingresa una carta a su mazo de cartas
     * @param idJugador identificador primario de jugador
     * @param carta La carta que se esta ingresando al mazo del jugador
     */
    public void setCarta(int idJugador, Carta carta){        
        try{
            if(this.manosJugadores.containsKey(idJugador)){
                ManoPoker mano = this.manosJugadores.get(idJugador);
                mano.setCarta(carta);
                this.manosJugadores.put(idJugador, mano);
            }else{
                ManoPoker mano = new ManoPoker(idJugador);
                mano.setCarta(carta);
                this.manosJugadores.put(idJugador, mano);
            }           
        }catch(Exception e){
            System.out.println("[Mesa.setCarta]" + e.getMessage());
        }
    }
}