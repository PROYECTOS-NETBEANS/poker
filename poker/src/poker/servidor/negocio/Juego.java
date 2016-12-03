package poker.servidor.negocio;

import java.util.HashMap;
import java.util.Iterator;
import poker.cliente.negocio.OnPackageListener;
import poker.servidor.datos.*;
/**
 * Clase principal que implement� el juego
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class Juego implements OnPackageListener{
    private Archivo bd = null;
    private HashMap<Integer, Mesa> mesas = null;
    private HashMap<Integer, Jugador> jugadores = null;
    
    /**
     * Identificador auto-incrementador para la mesa
     */
    private int idMesa = 1;
    /**
     * Identificador auto-incrementador para los jugadores
     */
    private int idJugador = 0;
    
    public Juego(){
        this.mesas = new HashMap<>();
        this.jugadores = new HashMap<>();
        this.idJugador = 0;
        this.idMesa = 1;
        this.bd = new Archivo();
    }
    
    /**
     * Crea un nuevo jugador con un monto de 1000 fichas por defecto
     * @param nick nombre de jugador
     * @param sexo Sexo del jugador
     */
    public void guardarJugador(String nick, String sexo){
        Jugador jg = new Jugador(nick, 1000, sexo);      
        jg.setId(bd.guardarJugador(jg));        
    }
    /**
     * Metodo que obtiene un jugador a partir del nick del usuario, si encuentra
     * se asigna a la lista de jugadores conectados y devuelve true
     * @param nick Nombre de usuario
     * @return true si encuentra al jugador en la bd, caso contrario falso
     */
    public boolean getJugador(String nick){
        Jugador jg = bd.getJugador(nick);
        if(jg != null){
            jugadores.put( jg.getId(), jg );
            return true;
        }else{
            return false;
        }        
    }
    /**
     * Elimina un jugador del juego y mesa
     * @param id Identificador unico de jugador
     */
    public void deletejugador(int id){
        
        // eliminamos de la mesa
        Iterator i = mesas.entrySet().iterator();
        while (i.hasNext()){
            Mesa mesa = (Mesa) i.next();
            if(mesa.existJugador(id)){
                mesa.deleteJugador(id);                
            }
        }
        
        jugadores.remove(id);

    }
    /**
     * Crea una mesa vacia e inicializa sus configuraciones por defecto
     * @return Devuelve la mesa creada
     */
    public Mesa crearMesa(){
        Mesa m = new Mesa(this.idMesa, Utils.nroMaximoJugadores, 10);
        mesas.put(idMesa, m);
        this.idMesa++;
        return m;
    }
    /**
     * Cuando se inicia la partida se asigna el dealer y los
     * jugadores que tendran la ciega peque�a y grande
     */
    public void iniciarPartida(){
        
    }
    /**
     * Metodo que devuelve una lista de mesas
     * @return 
     */
    public HashMap<Integer, Mesa> getMesas(){
        return this.mesas;
    }

    @Override
    public void onNuevaMesa(Mesa mesa) {
        
    }

    @Override
    public void onMesaLlena(int idMesa, boolean estado) {
        
    }

    @Override
    public void onNuevoJugador(Jugador jg) {
        
    }
    /**
     * Llega un identificador de mesa a donde quiere entrar el jugador
     * @param idMesa Identificador de mesa
     * @param idJugador Identificador primario de jugador
     */
    @Override
    public void onIngresarMesa(int idMesa, int idJugador) {
        this.ingresarJugadoraMesa(idMesa, idJugador);
    }
    //*******METODOS PRIVADOS DEL NEGOCIO DEL JUEGO 
    /**
     * Metodo que ingresa un jugador a una mesa
     * @param idMesa Identificador de mesa
     * @param idJugador Identificador de jugador
     */
    private void ingresarJugadoraMesa(int idMesa, int idJugador){
        System.out.println("no implementaod!! ingresaar mesa");
    }
}