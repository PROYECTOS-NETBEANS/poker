package poker.servidor.negocio;

import java.util.EventListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import jsocket.server.OnConnectedEventServer;
import jsocket.server.OnConnectedListenerServer;
import jsocket.server.JSocketServer;
import poker.servidor.datos.Jugador;
import poker.utils.datos.Constantes;
import poker.utils.datos.TipoPaquete;

public class ServerPoker implements OnConnectedListenerServer, OnPackageSendListenerServer{
    
    private JSocketServer servidor = null;
    private JuegoServer game = null;
    private AnalizadorServer anx = null;
    
    public ServerPoker(EventListener listener){
        this.inicializar(listener);
    }
    private void inicializar(EventListener listener){
        servidor = new JSocketServer(5555);
        servidor.addEventListener(listener);
        servidor.addEventListener(this);
        
        game = new JuegoServer();
        
        game.addEventListener(this);
        
        // Es el escuchador de paquetes
        anx = new AnalizadorServer();
        anx.addEventListener(game);
        
    }
    /**
     * Iniciamos el servidor y creamos las primeras 3 mesas
     */
    public void iniciarServidor(){
        servidor.iniciarServicio();
        game.crearMesa();
    }

    @Override
    public void onServerStar(OnConnectedEventServer oces) {
        System.out.println("onServerStar no implementado!!");
    }

    @Override
    public void onConnect(Object sender, OnConnectedEventServer data, String userName) {
       // Nno hacer nada cuando se conecta
       this.enviarDatosIniciales(userName);
    }
    // cuando se desconecta del servidor
    @Override
    public void onDisconnect(Object o, OnConnectedEventServer data, String userName) {
        if(data.getClientDisconnect()){
            this.usuarioDesconectado(data.getOrigenClient(), userName);
        }
    }

    @Override
    public void onRead(Object sender, OnConnectedEventServer data, String userName) {
        this.onRead(data.getMessageClient());
    }
    /**
     * Metodo encargado de eliminar un usuario que se acaba de desconectar
     * @param id Identificador unico de cliente en el socket
     * @param userName Nombre de usuario
     */
    private void usuarioDesconectado(int id, String userName){        
        int idJg = game.getIdJugadorByUserName(userName);
        if(idJg > 0){
            JSocketServer.removeClient(id);            
            this.game.setEstadoConexionJugador(idJg, Constantes.ESTADO_DESCONECTADO);
            this.enviarJugadorDesconectado(game.getJugadores().get(idJg));
        }
    }
    /**
     * Metodo que envia el jugador que se desconecto para que se eliminen de los clientes
     * @param jg Objeto jugador a eliminar
     */
    private void enviarJugadorDesconectado(Jugador jg){
        try{    
            System.out.println("jg desconectado : " + jg.getNickName());
            this.enviarJugador( jg, TipoPaquete.JUGADOR_DESCONECTADO);
        }catch(Exception e){
            System.out.println("[ServerPoker.enviarJugadorEliminado]" + e.getMessage());
        }
    }
    /**
     * Metodo que envia las mesas y jugadores al usuario que acaba de conectar
     * @param nick nombre de usuario
     */
    private void enviarDatosIniciales(String nick){
        if(nick.length() > 0){
            if(game.autenticarJugador(nick)){
                this.enviarJugadores();
                this.enviarMesas();                
            }
        }
    }
    /**
     * Metodo que envia al cliente todas la mesas
     * que hay creadas en el servidor
     */    
    private void enviarMesas(){
        try{
            HashMap<Integer, Mesa> mesas = game.getMesas();
            Iterator it = mesas.entrySet().iterator();
            while(it.hasNext()){
                Map.Entry e = (Map.Entry) it.next();
                this.enviarMesa((Mesa) e.getValue());
            }
        }catch(Exception e){
            System.out.println("[ServerPoker.EnviarMesas()] : " + e.getMessage());
        }
    }
    
    private void enviarJugadores(){
        try{
            HashMap<Integer, Jugador> jugadores = game.getJugadores();
            System.out.println("jugadores count : " + jugadores.size() );
            Iterator it = jugadores.entrySet().iterator();
            while(it.hasNext()){
                Map.Entry e =(Map.Entry) it.next();
                this.enviarJugador((Jugador) e.getValue(), TipoPaquete.JUGADOR);
            }
        }catch(Exception e){
            System.out.println("[ServerPoker.enviarJugagores]" + e.getMessage());
        }
    }
    /**
     * Metodo que analiza el tipo de paquete que llega del servidor
     */
    private void onRead(String data){
        anx.setMessage(data);
    }    
    /**
     * Envia un jugador a los clientes
     * @param j jugador que se enviará a los clientes
     */
    private void enviarJugador(Jugador j, TipoPaquete accion){
        servidor.sendMessageAll(anx.gEnviarJugador(j, accion), -1);
    }
    private void enviarMessage(String message, int idMesa){
        servidor.sendMessageAll(anx.gEnviarMessage(message, idMesa), -1);
    }
    /**
     * Envia una mesa a los clientes
     * @param m Mesa a enviar a los clientes
     */
    private void enviarMesa(Mesa m){
        servidor.sendMessageAll(anx.gEnviarMesa(m), -1);
    }
    /**
     * Envia el jugador que ingreso a todas las mesas para que se actualizen
     * @param idMesa identificador de mesa
     * @param j Jugador que ingreso a la partida
     */
    private void enviarJugadorIngresadoAMesa(Mesa mesa, Jugador j){        
        servidor.sendMessageAll(anx.gEnviarjugadorIngresadoAMesa(j, mesa), -1);        
    }
    /**
     * Crea una nueva mesa y la envia a todos los jugadores
     */
    public void nuevaMesa(){
        Mesa m = game.crearMesa();
        this.enviarMesa(m);
    }
    // metodos que se invocan para enviar mensajes a los clientes
    @Override
    public void onEnviarMesa(Mesa m) {
        this.enviarMesa(m);
    }

    @Override
    public void onEnviarJugadorIngresadoAMesa(Jugador j, Mesa mesa) {
       this.enviarJugadorIngresadoAMesa(mesa, j);
    }

    @Override
    public void onEnviarMessage(String message, int idMesa) {
        this.enviarMessage(message, idMesa);
    }
}