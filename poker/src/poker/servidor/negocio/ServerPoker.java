package poker.servidor.negocio;


import jsocket.server.*;

public class ServerPoker implements OnConnectedListenerServer{
    
    private JSocketServer servidor = null;
    private Juego game = null;
    
    public ServerPoker(){
        this.inicializar();
    }
    private void inicializar(){
        servidor = new JSocketServer(5555);
        servidor.addEventListener(this);
        
        game = new Juego();
    }
    
    public void iniciarServidor(){        
        game.crearMesa();
    }
    //--------------------------------------------------------------------------------
    // Escuchadores de eventos del socket
    @Override
    public void onServerStar(OnConnectedEventServer oces) {
        
    }

    @Override
    public void onConnect(Object o, OnConnectedEventServer oces, String string) {

    }

    @Override
    public void onDisconnect(Object o, OnConnectedEventServer oces) {

    }

    @Override
    public void onRead(Object o, OnConnectedEventServer oces, String string) {

    }

}