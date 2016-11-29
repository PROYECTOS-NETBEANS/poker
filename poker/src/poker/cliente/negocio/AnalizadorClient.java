package poker.cliente.negocio;
import java.util.EventListener;
import javax.swing.event.EventListenerList;
import poker.servidor.negocio.Mesa;
import poker.utils.datos.*;
import jsocket.client.JSocketClient;
/**
 * Clase que analiza cada paquete que llega del servidor
 * y ejecuta sus respectivos metodos del escuchador
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class AnalizadorClient {
    
    private EventListenerList listenerList = new EventListenerList();
    
    public AnalizadorClient(){
    }
        /**
     * Metodo que adiciona un escuchador a la lista de escuchadores
     * @param listener Escuchador a adiconar a la lista
     */
    public void addEventListener(EventListener listener){
        listenerList.add(EventListener.class, listener);
    }
    public void setConexion(JSocketClient cliente){
        
    }
    /**
     * Metodo que elimina un escuchador de la lista de escuchadores
     * @param listener Escuchador
     */
    public void removeEventListener(EventListener listener){
        listenerList.remove(EventListener.class, listener);
    }

    /**
     * Metodo que deserializar el mensaje que llega
     * @param data Mensaje que llega para su deserialización.
     */
    public void setMessage(String data){
        PaquetePk pk = (PaquetePk) Parser.stringToObject(data, PaquetePk.class);
        this.analizarPaquete(pk);
    }    
    private void analizarPaquete(PaquetePk p){
        switch(p.getTipoPaquete()){
            case MESA:
                this.nuevaMesa(p.getData());
                break;
            case JUGADOR:
                this.nuevoJugador(p.getData());
                break;
        }
    }
    private void nuevaMesa(String data){
        Mesa mesa = (Mesa) Parser.stringToObject(data, Mesa.class);
        
        Object[] listeners = listenerList.getListenerList();
        
        for(int i = 0; i < listeners.length; i++){
            if(listeners[i] instanceof OnPackageListener){
                 ((OnPackageListener) listeners[i]).onNuevaMesa(mesa);
            }
        }

    }
    private void nuevoJugador(String data){
        
    }
    //***METODOS PARA ENVIAR LOS PAQUETES AL SERVIDOR (empiezan con la letra g)
    
    /**
     * Metodo para generar el envio del identificador de la mesa al servidor
     * @param idMesa Identificador de mesa
     * @return una cadena para enviar al servidor
     */
    public String gIngresarMesa(int idMesa){
        PaquetePk pk = new PaquetePk(String.valueOf(idMesa), TipoPaquete.INGRESAR_A_MESA);
        return Parser.objectToString(pk);
    }
}
