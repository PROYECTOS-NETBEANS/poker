/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package poker.servidor.negocio;

import java.util.EventListener;
import javax.swing.event.EventListenerList;
import poker.servidor.datos.Jugador;
import poker.utils.datos.PaquetePk;
import poker.utils.datos.Parser;
import poker.utils.datos.TipoPaquete;

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
        switch(p.getTipoPaquete()){
            case INGRESAR_A_MESA:
                this.ingresarMesa(p.getData());
                break;
        }        
    }
    // METODOS PARA EMPAQUETAR LOS DATOS A ENVIAR
    /**
     * Metodo que empaqueta los datos de la mesa en un paquete
     * @param m Mesa a enviarse al cliente
     * @return String con la mesa encapsulada
     */
    public String gEnviarMesa(Mesa m){
        String mesa = Parser.objectToString(m);
        PaquetePk p = new PaquetePk(mesa, TipoPaquete.MESA);
        return Parser.objectToString(p);
    }
    /**
     * Metodo que encapsula un jugador dentro de un paquete
     * @param j Jugador a encapsular
     * @param accion TipoPaquete que se envia
     * @return Strin es el resultado de haber sido encapsulado
     */
    public String gEnviarJugador(Jugador j, TipoPaquete accion){
        String jugador = Parser.objectToString(j);
        PaquetePk p = new PaquetePk(jugador, accion);
        return Parser.objectToString(p);
    }
    // METODOS PARA INVOCAR A LOS EVENTOS
    private void ingresarMesa(String data){
        
        String mesa_jug = (String) Parser.stringToObject(data, String.class);
        System.out.println("analizadorServer.ingresarMesa >id mes jug : " + mesa_jug);
        String lista[] = mesa_jug.split("-");
        
        Object[] listeners = listenerList.getListenerList();
        
        for(int i = 0; i < listeners.length; i++){
            if(listeners[i] instanceof OnPackageReadListenerServer){
                 ((OnPackageReadListenerServer) listeners[i]).onIngresarMesa(Integer.valueOf(lista[0]), Integer.valueOf(lista[1]));
            }
        }
    }    
    
}
