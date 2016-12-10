package poker.cliente.negocio;

import java.util.HashMap;
import poker.servidor.datos.Jugador;
import poker.servidor.negocio.Mesa;
import java.util.Observable;
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
    
    private JuegoCliente(){
        this.mesas = new HashMap<>();
        this.jugadores = new HashMap<>();
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
        System.out.println("llego una mesa!!!");
    
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
     * @param jg Jugador que llega del servidor
     */
    private void addJugador(Jugador jg){
        System.out.println("id : "+ String.valueOf(jg.getId()) + " " + jg.getNickName());
        this.jugadores.put(jg.getId(), jg);
        
        System.out.println("id : "+ String.valueOf(jg.getId()) + " " + jg.getNickName());
        //this.notificarCambios();
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
    public void onIngresarMesa(int idMesa, int idJugador) {
        System.out.println("no implementado en el cliente el on ingresar mesa");
    }
    
    @Override
    public void onJugadorDesconectado(Jugador jg){
        this.deleteJugador(jg);
    }
}