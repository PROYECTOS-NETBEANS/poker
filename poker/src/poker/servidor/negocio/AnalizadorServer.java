/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package poker.servidor.negocio;

import java.util.EventListener;
import javax.swing.event.EventListenerList;
import poker.utils.datos.PaquetePk;
import poker.utils.datos.Parser;

/**
 * 
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class AnalizadorServer {
    
    private EventListenerList listenerList = null;
    
    public AnalizadorServer(){
        listenerList = new EventListenerList();
    }
    /**
     * Metodo que adiciona un escuchador a la lista de escuchadores
     * @param listener Escuchador a adiconar a la lista
     */
    public void addEventListener(EventListener listener){
        listenerList.add(EventListener.class, listener);
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
        
    }    
}
