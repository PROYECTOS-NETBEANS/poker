package poker.servidor.negocio;


import java.util.EventListener;
import jsocket.server.*;

public class ServerPoker{
    
    private JSocketServer servidor = null;
    private Juego game = null;
    
    public ServerPoker(EventListener listener){
        this.inicializar(listener);
    }
    private void inicializar(EventListener listener){
        servidor = new JSocketServer(5555);
        servidor.addEventListener(listener);        
        game = new Juego();
    }
    /**
     * Iniciamos el servidor y creamos la primera mesa
     */
    public void iniciarServidor(){        
        servidor.iniciarServicio();
        game.crearMesa();
    }    
}