package poker.cliente.negocio;

import java.util.HashMap;
import poker.cliente.negocio.OnPackageListener;
import poker.servidor.datos.Jugador;
import poker.servidor.negocio.Mesa;

/**
 * 
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class JuegoCliente implements OnPackageListener{
    /**
     * Lista de mesas que hay en el servidor
     */
    private HashMap<Integer, Mesa> mesas = null;
    
    public JuegoCliente(){
        this.mesas = new HashMap<>();
    }
    
    public Entidad getMesa(int index){
        
    }
    /**
     * Adiciona una mesa a la lista de mesas
     * @param m una mesa que llega del servidor
     */
    private void addMesa(Mesa m){
        this.mesas.put(m.getId(), m);
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
}
