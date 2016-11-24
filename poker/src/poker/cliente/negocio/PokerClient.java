package poker.cliente.negocio;
import java.util.EventListener;
import javax.swing.event.EventListenerList;
import jsocket.client.*;
/**
 * 
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class PokerClient implements OnConnectedListenerClient{
    private JSocketClient cliente = null;
    private JuegoCliente game = null;
    private Analizador anx = null;
    
    public PokerClient(int puerto, String ip){
        this.inicializar(puerto, ip);
        game = new JuegoCliente();
        anx = new Analizador();
        anx.addEventListener(game);
    }
    /**
     * Inicializa todos los objetos para la conexion     
     * @param puerto Puerto donde esta escuchando en el servidor
     * @param ip Dirección ip del servidor
     */
    private void inicializar(int puerto, String ip){
        try {
            cliente = new JSocketClient(puerto, ip);          
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
    /**
     * Metodo que que se ejecuta cuando llega un paquete del servidor
     * @param o Objeto donde se genero el evento
     * @param ocec Evento que se genera cuando llega el paquete
     */
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
     * Metodo que analiza el tipo de paquete que llega del servidor
     */
    private void onRead(String data){        
        anx.setMessage(data);        
    }
}
