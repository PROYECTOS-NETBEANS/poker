package poker.servidor.negocio;

import java.util.EventListener;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.event.EventListenerList;
import poker.servidor.datos.*;
import poker.utils.datos.Constantes;
/**
 * Clase principal que implementá el juego
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class JuegoServer implements OnPackageReadListenerServer{
    private Archivo bd = null;
    /**
     * Lista de mesas <Id de mesa, Mesa>
     */
    private HashMap<Integer, Mesa> mesas = null;
    /**
     * Lista de jugadores <id de jugador, jugador>
     */
    private HashMap<Integer, Jugador> jugadores = null;
    
    /**
     * Identificador auto-incrementador para la mesa
     */
    private int idMesa = 1;
    
    private EventListenerList listenerList = null;
    
    public JuegoServer(){
        this.mesas = new HashMap<>();
        this.jugadores = new HashMap<>();
        this.idMesa = 1;
        this.bd = new Archivo();
        this.listenerList = new EventListenerList();
    }
    public void addEventListener(EventListener listener){
        this.listenerList.add(EventListener.class, listener);
    }
    public void removeEventListener(EventListener listener){
        this.listenerList.remove(EventListener.class, listener);
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
    public boolean autenticarJugador(String nick){
        Jugador jg = bd.getJugador(nick);
        if(jg != null){
            jugadores.put( jg.getId(), jg );
            return true;
        }else{
            return false;
        }
    }
    /**
     * Elimina un jugador del juego y de la mesa
     * @param nick nombre de jugador a eliminar
     * @return Retorno el jugador que se elimino, en otro caso retorna nulo
     */
    public Jugador deletejugador1(String nick){
        try{
            Jugador jg = bd.getJugador(nick);

            // eliminamos de la mesa
            Iterator i = mesas.values().iterator();
            while (i.hasNext()){
                System.out.println("llegue a has");
                Mesa mesa = (Mesa) i.next();
                if(mesa.existJugador(jg.getId())){
                    mesa.deleteJugador(jg.getId());
                }
            }
            jugadores.remove(jg.getId());
            return jg;
        }catch(Exception e){
            System.out.println("[Juego.deleteJugador()]" + e.getMessage());
            return null;
        }
    }
    /**
     * Cambia el estado de la conexion de la conexion
     * @param idJugador Identificador de jugador
     * @param estado Estado de conexion.
     */
    public void setEstadoConexionJugador(int idJugador, Constantes estado){
        Jugador j = jugadores.get(idJugador);
        j.setEstadoJugador(estado);
        jugadores.put(j.getId(), j);
        this.actualizarJugadorInMesa(j);
    }
    public void setEstadoTurno(int idJugador, Constantes turno){
        Jugador j = jugadores.get(idJugador);
        j.setTurnoJugador(turno);
        jugadores.put(j.getId(), j);
    }
    /**
     * Actulaliza un jugador en todas las mesas
     * @param j jugador que se va actualizar
     */
    public void actualizarJugadorInMesa(Jugador j){
        for (Iterator iterator = this.mesas.values().iterator(); iterator.hasNext();) {
            Mesa m = (Mesa) iterator.next();
            if(m.getJugadores().containsKey(j.getId())){
                // actualizo la mesa del jugador
                m.setJugador(j);
                this.mesas.put(m.getId(), m);
            }
        }
    }
    /**
     * Busca el identificador de jugador en base al nombre
     * @param userName Nombre de usuario a buscar
     * @return Identificador primario de jugador
     */
    public int getIdJugadorByUserName(String userName){
        try {
            return bd.getJugador(userName).getId();
        } catch (Exception e) {
            System.out.println("[JuegoServer.getJugadorByUserName] " + e.getMessage());
            return -1;
        }
    }
    /**
     * Crea una mesa vacia e inicializa sus configuraciones por defecto
     * @return Devuelve la mesa creada
     */
    public Mesa crearMesa(){
        try {
            Mesa m = new Mesa(this.idMesa, Utils.nroMaximoJugadores, 
                                Utils.nroMaximoJugadores, Utils.ciegaAlta, 
                                Utils.ciegaPequeña, Utils.nroMinimoJugadores);
            mesas.put(idMesa, m);
            this.idMesa++;
            return m;
        } catch (Exception e) {
            System.out.println("[JuegoServer.crearMesa] " + e.getMessage());
            return null;
        }


    }
    /**
     * Cuando se inicia la partida se asigna el dealer y los
     * jugadores que tendran la ciega pequeña y grande
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
    /**
     * Metodo que devuelve una lista de jugadores conectados al servidor
     * @return HashMap lista de jugadores
     */
    public HashMap<Integer, Jugador> getJugadores(){
        return this.jugadores;
    }

    /**
     * Llega un identificador de mesa a donde quiere entrar el jugador
     * @param idMesa Identificador de mesa
     * @param idJugador Identificador primario de jugador
     */
    @Override
    public void onIngresarMesa(int idMesa, int idJugador) {
        this.ingresarJugadorAMesa(idMesa, idJugador);
    }
    //*******METODOS PRIVADOS DEL NEGOCIO DEL JUEGO 
    /**
     * Metodo que ingresa un jugador a una mesa
     * @param idMesa Identificador de mesa
     * @param idJugador Identificador de jugador
     */
    private void ingresarJugadorAMesa(int idMesa, int idJugador){
        try{
            if(this.mesas.containsKey(idMesa) && this.jugadores.containsKey(idJugador)){
                Mesa m = this.mesas.get(idMesa);
                m.setJugador(jugadores.get(idJugador));
                this.mesas.put(m.getId(), m);
                System.out.println("mensage se enviara a : " + jugadores.get(idJugador).getNickName());
                this.onEnviarMessage("Ingreso a la mesa : " + jugadores.get(idJugador).getNickName()  , idMesa);
                this.onEnviarJugadorIngresaMesa(jugadores.get(idJugador), m);                
            }else{
                System.out.println("[Juego.ingresarJugadorAMesa] No se encontro mesa o jugador para adicionar!!");
            }            
        }catch(Exception e){
            System.out.println("[Juego.ingresarJugadorAMesa]" + e.getMessage());
        }
    }
    /**
     * Metodo que invoca el evento para enviar las mesas a los clientes
     */
    private void onEnviarMesa(Mesa m){

        Object[] listeners = listenerList.getListenerList();
        
        for (Object listener : listeners) {
            if (listener instanceof OnPackageSendListenerServer) {
                ((OnPackageSendListenerServer) listener).onEnviarMesa(m);
            }
        }
    }
    
    private void onEnviarJugadorIngresaMesa(Jugador j, Mesa m){
        
        Object[] listeners = listenerList.getListenerList();
        
        for (Object listener : listeners) {
            if (listener instanceof OnPackageSendListenerServer) {
                ((OnPackageSendListenerServer) listener).onEnviarJugadorIngresadoAMesa(j, m);
            }
        }
    }
    private void onEnviarMessage(String msg, int idMesa){
        
        Object[] listeners = listenerList.getListenerList();
        
        for (Object listener : listeners) {
            if (listener instanceof OnPackageSendListenerServer) {
                ((OnPackageSendListenerServer) listener).onEnviarMessage(msg, idMesa);
            }
        }
    }    
}