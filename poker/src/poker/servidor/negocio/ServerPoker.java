package poker.servidor.negocio;

import java.util.EventListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import jsocket.server.*;
import poker.servidor.datos.Jugador;
import poker.utils.datos.PaquetePk;
import poker.utils.datos.Parser;
import poker.utils.datos.TipoPaquete;

public class ServerPoker implements OnConnectedListenerServer{
    
    private JSocketServer servidor = null;
    private Juego game = null;
    private AnalizadorServer anx = null;
    
    public ServerPoker(EventListener listener){
        this.inicializar(listener);
    }
    private void inicializar(EventListener listener){
        servidor = new JSocketServer(5555);
        servidor.addEventListener(listener);
        servidor.addEventListener(this);
        
        game = new Juego();
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

    @Override
    public void onDisconnect(Object o, OnConnectedEventServer oces) {
        System.out.println("onDisconnect no implementado");
    }

    @Override
    public void onRead(Object sender, OnConnectedEventServer data, String userName) {
        System.out.println("msg d Cliente : " + data.getMessageClient());
        System.out.println("idCliente Destino : " + String.valueOf(data.getDestinoClient()) );
        System.out.println("idCliente Origen : " + String.valueOf(data.getDestinoClient()));
    }
    
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
                this.enviarJugador((Jugador) e.getValue());
            }
        }catch(Exception e){
            System.out.println("[ServerPoker.enviarJugagores]" + e.getMessage());
        }
    }
   /**
     * Envia un jugador a los clientes
     * @param j jugador que se enviará a los clientes
     */
    private void enviarJugador(Jugador j){
        System.out.println("enviado jg nick: " + j.getNickName());
        String jugador = Parser.objectToString(j);
        PaquetePk p = new PaquetePk(jugador, TipoPaquete.JUGADOR);
        servidor.sendMessageAll(Parser.objectToString(p), -1);
    }    
    /**
     * Envia una mesa a los clientes
     * @param m Mesa a enviar a los clientes
     */
    private void enviarMesa(Mesa m){
        String mesa = Parser.objectToString(m);
        PaquetePk p = new PaquetePk(mesa, TipoPaquete.MESA);
        servidor.sendMessageAll(Parser.objectToString(p) , -1);
    }
    public void nuevaMesa(){
        Mesa m = game.crearMesa();
        this.enviarMesa(m);
    }
}