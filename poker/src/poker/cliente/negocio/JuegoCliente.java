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
    
    
    /**
     * Adiciona una mesa a la lista de mesas
     * @param m 
     */
    private void addMesa(Mesa m){
        this.mesas.put(m.getId(), m);
        System.out.println("mesa cli : " + Integer.toString(m.getId()));
    }
    
    private void setEstadoMesa(int idMesa, boolean estado){
        this.mesas.get(idMesa).setEstadoMesa(estado);                
    }
    
    private void addJugador(Jugador jg){
        System.out.println("Nuevo jugador no implementado!!!!");
    }
    // de aqui hacia abajo solo los metodos de la interfaz
    @Override
    public void nuevaMesa(Mesa mesa) {
        this.addMesa(mesa);
    }

    @Override
    public void mesaLlena(int idMesa, boolean estado) {
        this.setEstadoMesa(idMesa, estado);
    }

    @Override
    public void nuevoJugador(Jugador jg) {
        this.addJugador(jg);
    }

}
