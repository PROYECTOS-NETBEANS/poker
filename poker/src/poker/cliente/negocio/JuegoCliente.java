package poker.cliente.negocio;

import java.util.HashMap;
import poker.servidor.datos.Jugador;
import poker.servidor.negocio.Mesa;
import java.util.Observable;
/**
 * Esto se crea cada vez que vez que se conecta al servidor
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class JuegoCliente extends Observable implements OnPackageListener {
    
    private static JuegoCliente game = new JuegoCliente();
    /**
     * Lista de mesas que hay en el servidor
     */
    private HashMap<Integer, Mesa> mesas = null;
    
    private JuegoCliente(){
        this.mesas = new HashMap<>();
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
     * Adiciona una mesa a la lista de mesas
     * @param m una mesa que llega del servidor
     */
    private void addMesa(Mesa m){
        this.mesas.put(m.getId(), m);
        System.out.println("llego una mesa!!!");
        this.notificarCambios();
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
        System.out.println("Nuevo jugador no implementado!!!!");
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

    private void notificarCambios(){
        this.setChanged();
        this.notifyObservers();
    }

    @Override
    public void onIngresarMesa(int idMesa) {
        
    }
}