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
public class PokerClient {
    private JSocketClient cliente = null;
    
    public PokerClient(EventListener listener, int puerto, String ip){
        this.inicializar(listener, puerto, ip);
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
        } catch (Exception e) {
            System.out.println("Error pokerCliente.inicializar : " + e.getMessage());
        }
    }
    /**
     * Inicializa el servicio con el servidor
     * @param nick Nombre de usuario del cliente
     */
    public void conectarServidor(String nick){
        try {
            cliente.conectarServidor(nick);
        } catch (Exception e) {
            System.out.println("Error pokerClient.conectarServidor : " + e.getMessage());
        }
        
    }
    
}
