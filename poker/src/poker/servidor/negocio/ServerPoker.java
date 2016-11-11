package poker.servidor.negocio;

import java.util.LinkedList;
import jsocket.client.OnConnectedEventClient;
import jsocket.server.*;

public class ServerPoker implements jsocket.client.OnConnectedListenerClient{
    
    private JSocketServer servidor = null;
    private LinkedList<Mesa> mesas = null;
    private LinkedList<Jugador> jugadores = null;
    
    public ServerPoker(){
        servidor = new JSocketServer(5555);
        servidor.addEventListener(this);
        mesas = new LinkedList<Mesa>();
        jugadores = new LinkedList<Jugador>();
        
    }
    
    @Override
    public void onConnect(Object o, OnConnectedEventClient ocec) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onDisconnect(Object o, OnConnectedEventClient ocec) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onRead(Object o, OnConnectedEventClient ocec) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onConnectRefused() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onConnectFinally() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}