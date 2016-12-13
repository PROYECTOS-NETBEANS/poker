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
    /**
     * La casa donde esta el pozo acumulado y su baraja
     */
    private Casa house = null;
    /**
     * Apuesta minima que se podra apostar
     */
    private int apuestaMin = 20;
    /**
     * Ciega alta de la mesa
     */
    private int ciegaAlta = 100;
    /**
     * Ciega pequeña de la mesa
     */
    private int ciegaBaja = 50;
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
    private int nroMaxJugadores = 0;
    /**
     * Nro minimo de jugadores para empezar la partida
     */
    private int nroJugMin = 0;
    
    /**
     * Inicializacion con la configuraciones iniciales
     * @param id Identificador unico de mesa
     * @param nroMaxJug Nro. maximo de jugadores
     * @param ciegaAlta ciega alta
     * @param ciegaBaja ciega baja
     * @param apuestaMin Es el monto minimo que se debe de apostar
     * @param nroJugMin Es el numero de jugadores minimo para empezar la partida
     */
    public Mesa(int id, int apuestaMin, int nroMaxJug, int ciegaAlta, int ciegaBaja, int nroJugMin){
        this.jugadores = new HashMap<>();
        this.baraja = new Baraja();
        this.house = new Casa();
        this.id = id;
        this.nroJugMin = nroJugMin;
        this.estado = true;
        this.nroMaxJugadores = nroMaxJug;
        this.apuestaMin = apuestaMin;
        this.ciegaAlta = ciegaAlta;
        this.ciegaBaja = ciegaBaja;
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
            if(this.jugadores.size() < this.nroMaxJugadores){
                this.jugadores.put(jg.getId(), jg);
                this.estado = ((this.getJugadores().size() < this.nroMaxJugadores) ? true : false);
                System.out.println("Estado de mesa : " + String.valueOf(this.estado));
            }
            
        } catch (Exception e) {
            System.out.println("[Mesa.setJugador]" + e.getMessage());
        }        
    }
    
    /**
     * Elimina de la mesa al jugador que se a desconectado
     * @param id Identificador de mesa
     */
    public void deleteJugador(int id){
        try {
            this.jugadores.remove(id);
            this.estado = ((this.getJugadores().size() < this.nroMaxJugadores) ? true : false);
        } catch (Exception e) {
            System.out.println("[Mesa.deleteJugador]" + e.getMessage());
        }
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
     * Cuando se cumple la condicion de tener el minimo de jugadores
     * se inicia la partida automaticamente
     */
    public void iniciarPartida(){
        try {
            if(this.getJugadores().size() >= this.nroJugMin){
                if(!this.baraja.estaBarajada()){
                    this.baraja.barajar();
                    this.actualizarTipoJugadores();
                }
            }
        } catch (Exception e) {
            System.out.println("[Mesa.iniciarPartida] " + e.getMessage());
        }
    }
    /**
     * Metodo que obtine una carta de la baraja
     * @return Carta sacada de la baraja
     */
    public Carta getRepartirCarta(){
        try {
            return this.baraja.getCarta();
        } catch (Exception e) {
            System.out.println("[Mesa.getRepartirCarta] " + e.getMessage());
            return null;
        }
    }
    /**
     * Metodo que configura que jugadores seran los dealer
     * ciega alta y ciega pequeña
     */
    public void actualizarTipoJugadores(){
        if(this.getJugadores().size() >= this.nroJugMin){
            System.out.println("[Mesa.actualizarTipoJugadores] no se esta aplicando las ciegas dealer" );
        }
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