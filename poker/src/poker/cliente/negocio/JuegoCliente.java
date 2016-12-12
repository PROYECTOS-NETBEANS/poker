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
    /**
     * Lista de jugadores conectados al servidor
     */
    private HashMap<Integer, Jugador> jugadores = null;
    
    /**
     * Es el jugador que este cliente
     */
    private Jugador player = null;
    private Mesa mesa = null;
    private String nick = null;
    
    private JuegoCliente(){
        this.mesas = new HashMap<>();
        this.jugadores = new HashMap<>();       
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
     * Metodo que devuelve la lista de jugadores de mi mesa de juego
     * @param idMesa Identificador de mesa
     * @return Mapa con los jugadores de la mesa
     */
    public HashMap<Integer, Jugador> getJugadoresDeMesa(){
        try{
            if(this.mesa == null)
                System.out.println("mesa nulo XXXXXXXXXXXXx");
            
            if(this.mesa.getJugadores() == null)
                System.out.println("jugadores nulos XXXXXXXXXXXXx");
            
            return this.mesa.getJugadores();
            
        }catch(Exception e){
            System.out.println("[JuegoCliente.getJugadoresDeMesa]" + e.getMessage());
            return null;
        }
    }
    /**
     * Adiciona una mesa a la lista de mesas 
     * y ademas si estoy en la mesa actualiza mi mesa
     * @param m una mesa que llega del servidor
     */
    private void addMesa(Mesa m){
        try{
            this.mesas.put(m.getId(), m);
            if(player != null){
                if(m.existJugador(player.getId())){
                    this.mesa = m;
                    System.out.println("[JuegoCliente.addMesa] actualizando mi mesa !!");
                }
            }
        }catch(Exception e){
            System.out.println("[JuegoCliente.addMesa]" + e.getMessage());
        }

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
     * Adiciona un jugador a la lista de jugadores
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
     * Metodo que ingresa un jugador a la mesa
     * @param j Jugador a actualizar
     */
    private void ingresarJugadorAMesa(Jugador j, Mesa m){
        try {
            if(this.mesa == null){
               if(this.player.getId() == j.getId())
                   this.mesa = m;
            }
            
            if(this.mesa.getId() == m.getId()){
                this.mesa = m;
                this.mesa.setJugador(j);
            }
            this.mesas.put(m.getId(), m);
        } catch (Exception e) {
            System.out.println("[JuegoCliente.ingresarJugadorAMesa]" + e.getMessage());
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
    /**
     * Metodo que nos devuelve el Identificador de mesa donde estamos participando en el juego
     * @return Identificador de mesa donde esta jugando
     */
    public int getIdMesaDeJuego(){
        try{
            if(this.mesa != null)
                return this.mesa.getId();
            else
                return -1;
        }catch(Exception e){
            System.out.println("[JuegoCliente.getMesaDeJuego]" + e.getMessage());
            return -1;
        }
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
        System.out.println("JuegoCliente.onNuevoJugador ok");
        this.addJugador(jg);
    }

    @Override
    public void onJugadorDesconectado(Jugador jg){
        System.out.println("JuegoCliente.onJugadorDesconectado ok");
        this.deleteJugador(jg);
    }

    @Override
    public void onJugadorIngresaAMesa(Jugador jg, Mesa m) {
        this.ingresarJugadorAMesa(jg, m);
        System.out.println("[JuegoCliente.onJugadorIngresaAMesa] ok");
    }
}