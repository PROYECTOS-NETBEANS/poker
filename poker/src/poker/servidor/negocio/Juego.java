package poker.servidor.negocio;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Clase principal que implementá el juego
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class Juego {
    
    private HashMap<Integer, Mesa> mesas = null;
    private HashMap<Integer, Jugador> jugadores = null;
    
    public Juego(){
        mesas = new HashMap<>();
        jugadores = new HashMap<>();
    }
    
    /**
     * Crea un nuevo jugador con un monto de 1000 fichas por defecto
     * y se lo adiciona a la lista de jugadores conectados
     * @param id Identificador unico de jugador
     * @param nick nombre de jugador
     * @param sexo Sexo del jugador
     */
    public void setJugador(int id ,String nick, String sexo ){
        Jugador jg = new Jugador(id, nick, 1000, sexo);
        jugadores.put(id, jg);
    }
    /**
     * Elimina un jugador del juego y mesa
     * @param id Identificador unico de jugador
     */
    public void deletejugador(int id){
        
        // eliminamos de la mesa
        Iterator i = mesas.entrySet().iterator();
        while (i.hasNext()){
            Mesa mesa = (Mesa) i.next();
            if(mesa.existJugador(id)){
                mesa.deleteJugador(id);                
            }
        }
        
        jugadores.remove(id);

    }
    
    public void crearMesa(){
        
    }
}