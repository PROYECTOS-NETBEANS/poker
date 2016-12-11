package poker.cliente.negocio;

import java.util.HashMap;
import poker.servidor.datos.Jugador;
import poker.servidor.negocio.Mesa;
/**
 * Esto se crea cada vez que vez que se conecta al servidor
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class JuegoCliente implements OnPackageListenerClient {
    
    private static JuegoCliente game = new JuegoCliente();
    /**
     * Lista de mesas que hay en el servidor
     */
    private HashMap<Integer, Mesa> mesas = null;
    private HashMap<Integer, Jugador> jugadores = null;
    
    /**
     * Es el jugador que de este cliente
     */
    private Jugador player = null;
    private String nick = null;
    
    private JuegoCliente(){
        this.mesas = new HashMap<>();
        this.jugadores = new HashMap<>();
        //this.jugadores = null;
    }
    /**
     * Metodo que devuelve el jugador actual. es decir su propia informacion
     * @return Jugador con la informacion del jugador
     */
    public Jugador getJugador(){
        return this.player;
    }
    /**
     * Adiciono el nick del jugador
     * @param nick Nombre de usuario del cliente
     */
    public void setNickName(String nick){
        this.nick = nick;
    }
    
    public static JuegoCliente getJuegoCliente(){
        if(game == null){
            game = new JuegoCliente();
        }
        return game;
    }
    /**
     * metodo que devuelve las mesas que hay en el servidor
     * @return 
     */
    public HashMap getMesas(){

        return ((mesas.size() > 0) ? this.mesas : null);
        
    }
    /**
     * metodo que devuelve la lista de jugadores conectados en el servidor
     * @return HasMap<Integer, Jugador>
     */
    public HashMap getJugadores(){

        return ((jugadores.size() > 0) ? this.jugadores : null);
        
    }
    
    /**
     * Adiciona una mesa a la lista de mesas
     * @param m una mesa que llega del servidor
     */
    private void addMesa(Mesa m){
        this.mesas.put(m.getId(), m);
        System.out.println("llego una mesa : " + String.valueOf(m.getId()));
    
    }
    /**
     * Cambia de Estado a la mesa
     * @param idMesa Identificador primario de mesa
     * @param estado Estado de mesa
     */
    private void setEstadoMesa(int idMesa, boolean estado){
        this.mesas.get(idMesa).setEstadoMesa(estado);                
    }
    /**
     * Adiciona un jugador a la lista de jugadores de la mesa
     * Ademas verifica si el nick de este jugador es igual al jugador que llega.
     * @param jg Jugador que llega del servidor
     */
    private void addJugador(Jugador jg){
        try{            
            this.jugadores.put(jg.getId(), jg);
            
            if(this.player == null){
                if(nick.equals(jg.getNickName())){
                    this.player = jg;
                }
            }
        }catch(Exception e){
            System.out.println("[JuegoCliente.addJugador]" + e.getMessage());
        }
    }
    
    /**
     * Elimina un jugador de la lista de jugadores y de la mesa
     */
    private void deleteJugador(Jugador jg){    
        jugadores.remove(jg.getId());
        // aqui creo que hay que eliminar de la mesa tambien
        System.out.println("jugador desconectado : " + jg.getNickName());
    }
    
    // de aqui hacia abajo solo los metodos de la interfaz
    @Override
    public void onNuevaMesa(Mesa mesa) {
        this.addMesa(mesa);
    }

    @Override
    public void onMesaLlena(int idMesa, boolean estado) {
        this.setEstadoMesa(idMesa, estado);
    }

    @Override
    public void onNuevoJugador(Jugador jg) {
        this.addJugador(jg);
    }

    @Override
    public void onJugadorDesconectado(Jugador jg){
        this.deleteJugador(jg);
    }
}