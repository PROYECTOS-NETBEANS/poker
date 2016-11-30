package poker.servidor.negocio;


import java.util.EventListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import jsocket.server.*;
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
    public void onConnect(Object o, OnConnectedEventServer oces, String string) {
        // cuando se conecte un usuario debo de enviarle todas las mesas del servidor
       this.enviarMesas();
    }

    @Override
    public void onDisconnect(Object o, OnConnectedEventServer oces) {
        System.out.println("onDisconnect no implementado");
    }

    @Override
    public void onRead(Object o, OnConnectedEventServer oces, String string) {
        anax.se
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
                this.enviarMesa((Mesa)e.getValue());
            }
        }catch(Exception e){
            System.out.println("[ServerPoker.EnviarMesas()] : " + e.getMessage());
        }
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