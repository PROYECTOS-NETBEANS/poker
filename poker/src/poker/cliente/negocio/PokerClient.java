package poker.cliente.negocio;
import java.util.EventListener;
import jsocket.client.*;
import poker.utils.datos.*;
/**
 * 
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class PokerClient implements OnConnectedListenerClient{
    private JSocketClient cliente = null;
    private JuegoCliente game = null;
    private Analizador anx = null;
    
    public PokerClient(EventListener listener, int puerto, String ip){        
        this.inicializar(listener, puerto, ip);
        game = new JuegoCliente();
        this.anx = new Analizador();
    }
    /**
     * Inicializa todos los objetos para la conexion 
     * @param listener Escuchador de eventos que se generan
     * @param puerto Puerto donde esta escuchando en el servidor
     * @param ip Dirección ip del servidor
     */
    private void inicializar(EventListener listener, int puerto, String ip){
        try {
            cliente = new JSocketClient(puerto, ip);
            //cliente.addEventListener(listener);
            cliente.addEventListener(this);
        } catch (Exception e) {
            System.out.println("Error pokerCliente.inicializar : " + e.getMessage());
        }
    }
    /**
     * Inicializa y conecta el servicio con el servidor
     * @param nick Nombre de usuario del cliente
     */
    public void conectarServidor(String nick){
        try {
            cliente.conectarServidor(nick);
        } catch (Exception e) {
            System.out.println("Error pokerClient.conectarServidor : " + e.getMessage());
        }        
    }

    @Override
    public void onConnect(Object o, OnConnectedEventClient ocec) {
        System.out.println("onconnect no implementado");
    }

    @Override
    public void onDisconnect(Object o, OnConnectedEventClient ocec) {
        System.out.println("onDisconnect no implementado");
    }

    @Override
    public void onRead(Object o, OnConnectedEventClient ocec) {
        this.onRead(ocec.getMessage());
    }
    
    @Override
    public void onConnectRefused() {
        System.out.println("onconnectRefused no implementado");
    }

    @Override
    public void onConnectFinally() {
        System.out.println("onConnectFinally no implementado");
    }
    /**
     * 
     */
    private void onRead(String data){
        PaquetePk pk = (PaquetePk) Parser.stringToObject(data, PaquetePk.class);
        anx.analizarPaquete(pk);
        
    }
}
