/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package poker.cliente.negocio;
import java.util.EventListener;
import jsocket.client.*;
/**
 * 
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class PokerClient implements OnConnectedListenerClient{
    private JSocketClient cliente = null;
    private JuegoCliente game = null;
    
    public PokerClient(EventListener listener, int puerto, String ip){        
        this.inicializar(listener, puerto, ip);
        game = new JuegoCliente();
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
            cliente.addEventListener(listener);
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
        System.out.println("cuando llegue un paquete hay que desglosar");
        
    }

    @Override
    public void onConnectRefused() {
        System.out.println("onconnectRefused no implementado");
    }

    @Override
    public void onConnectFinally() {
        System.out.println("onConnectFinally no implementado");
    }
}
