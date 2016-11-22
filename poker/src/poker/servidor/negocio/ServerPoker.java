package poker.servidor.negocio;


import java.util.EventListener;
import jsocket.server.*;
import poker.utils.datos.PaquetePk;
import poker.utils.datos.Parser;
import poker.utils.datos.TipoPaquete;

public class ServerPoker implements OnConnectedListenerServer{
    
    private JSocketServer servidor = null;
    private Juego game = null;
    
    public ServerPoker(EventListener listener){
        this.inicializar(listener);
    }
    private void inicializar(EventListener listener){
        servidor = new JSocketServer(5555);
        servidor.addEventListener(listener);
        servidor.addEventListener(this);
        game = new Juego();
    }
    /**
     * Iniciamos el servidor y creamos las primeras 3 mesas
     */
    public void iniciarServidor(){        
        servidor.iniciarServicio();
        game.crearMesa();
        game.crearMesa();
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
        System.out.println("onRead no implementado!!");
    }
    
    /**
     * Metodo que envia al cliente todas la mesas
     * que hay creadas en el servidor
     */    
    private void enviarMesas(){        
        String data = Parser.objectToString(game.getMesas());
        PaquetePk p = new PaquetePk(data, TipoPaquete.LISTA_MESAS);
        // solo enviamos el paquete encapsulado al cliente        
        servidor.sendMessageAll(Parser.objectToString(p), -1);        
    }
}