package poker.servidor.negocio;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;
import poker.servidor.datos.Archivo;
import poker.servidor.datos.Jugador;
import poker.utils.datos.*;
/**
 * 
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class Baraja implements Serializable{
    private Stack<Carta> pila = null;
    public boolean estaBarajado = false;
    public Baraja(){
        pila = new Stack<>();
        estaBarajado = false;
    }
    
    /**
     * Ingresa una carta a la baraja
     * @param carta Carta que se ingresa a la baraja
     */
    public void setCarta(Carta carta){
        pila.push(carta);
    }
    /**
     * Metodo que obtiene una carta de la baraja
     * @return Carta que se obtiene de la baraja
     */
    public Carta getCarta(){
        if(!pila.empty()){
            return this.pila.pop();
        }else{
            return null;
        }
    }
    /**
     * Verifica si las cartas de la mesa esta barajada
     * @return true si esta barajada, en otro caso false
     */
    public boolean estaBarajada(){
        return this.estaBarajado;
    }
    /**
     * Metodo que baraja las cartas
     */
    public void barajar(){
        LinkedList<Carta> cartas = this.inicializarBaraja();
        pila.clear();
        Random r = new Random();
        
        while(cartas.size() > 0){            
            int i = Math.abs(r.nextInt(cartas.size()));
            Carta  c = cartas.remove(i);
            pila.add(c);
            System.out.println(c.toString());            
        }
        this.estaBarajado = true;
    }

    public static void main(String arg[]){
        Archivo bd = new Archivo();
        /*//ESTOS SON LOS JUGADORES ACTIVOS
        bd.guardarJugador(new Jugador("mikezen", 1600, "M"));
        bd.guardarJugador(new Jugador("juan", 1000, "M"));
        bd.guardarJugador(new Jugador("pedro", 1500, "M"));
        bd.guardarJugador(new Jugador("maria", 1200, "F"));
        bd.guardarJugador(new Jugador("elena", 1000, "F"));
        */
        
        Jugador j = bd.getJugador("mikezen");
               
    }
    
    /**
     * Metodo que inicializa con cuantas cartas contara la baraja
     * @return Retorna una lista de cartas inicializadas
     */
    private LinkedList<Carta> inicializarBaraja(){
        LinkedList<Carta> cartas = new LinkedList();
                
        cartas.add(new Carta(2, Constantes.CARTA_CORAZON, Constantes.COLOR_ROJO));
        cartas.add(new Carta(3, Constantes.CARTA_CORAZON, Constantes.COLOR_ROJO));
        cartas.add(new Carta(4, Constantes.CARTA_CORAZON, Constantes.COLOR_ROJO));
        cartas.add(new Carta(5, Constantes.CARTA_CORAZON, Constantes.COLOR_ROJO));
        cartas.add(new Carta(6, Constantes.CARTA_CORAZON, Constantes.COLOR_ROJO));
        cartas.add(new Carta(7, Constantes.CARTA_CORAZON, Constantes.COLOR_ROJO));
        cartas.add(new Carta(8, Constantes.CARTA_CORAZON, Constantes.COLOR_ROJO));
        cartas.add(new Carta(9, Constantes.CARTA_CORAZON, Constantes.COLOR_ROJO));
        cartas.add(new Carta(10, Constantes.CARTA_CORAZON, Constantes.COLOR_ROJO));
        cartas.add(new Carta(11, Constantes.CARTA_CORAZON, Constantes.COLOR_ROJO));
        cartas.add(new Carta(12, Constantes.CARTA_CORAZON, Constantes.COLOR_ROJO));
        cartas.add(new Carta(13, Constantes.CARTA_CORAZON, Constantes.COLOR_ROJO));
        cartas.add(new Carta(14, Constantes.CARTA_CORAZON, Constantes.COLOR_ROJO));

        cartas.add(new Carta(2, Constantes.CARTA_DIAMANTE, Constantes.COLOR_ROJO));
        cartas.add(new Carta(3, Constantes.CARTA_DIAMANTE, Constantes.COLOR_ROJO));
        cartas.add(new Carta(4, Constantes.CARTA_DIAMANTE, Constantes.COLOR_ROJO));
        cartas.add(new Carta(5, Constantes.CARTA_DIAMANTE, Constantes.COLOR_ROJO));
        cartas.add(new Carta(6, Constantes.CARTA_DIAMANTE, Constantes.COLOR_ROJO));
        cartas.add(new Carta(7, Constantes.CARTA_DIAMANTE, Constantes.COLOR_ROJO));
        cartas.add(new Carta(8, Constantes.CARTA_DIAMANTE, Constantes.COLOR_ROJO));
        cartas.add(new Carta(9, Constantes.CARTA_DIAMANTE, Constantes.COLOR_ROJO));
        cartas.add(new Carta(10, Constantes.CARTA_DIAMANTE, Constantes.COLOR_ROJO));
        cartas.add(new Carta(11, Constantes.CARTA_DIAMANTE, Constantes.COLOR_ROJO));
        cartas.add(new Carta(12, Constantes.CARTA_DIAMANTE, Constantes.COLOR_ROJO));
        cartas.add(new Carta(13, Constantes.CARTA_DIAMANTE, Constantes.COLOR_ROJO));
        cartas.add(new Carta(14, Constantes.CARTA_DIAMANTE, Constantes.COLOR_ROJO));
 
        cartas.add(new Carta(2, Constantes.CARTA_TREBOL, Constantes.COLOR_NEGRO));
        cartas.add(new Carta(3, Constantes.CARTA_TREBOL, Constantes.COLOR_NEGRO));
        cartas.add(new Carta(4, Constantes.CARTA_TREBOL, Constantes.COLOR_NEGRO));
        cartas.add(new Carta(5, Constantes.CARTA_TREBOL, Constantes.COLOR_NEGRO));
        cartas.add(new Carta(6, Constantes.CARTA_TREBOL, Constantes.COLOR_NEGRO));
        cartas.add(new Carta(7, Constantes.CARTA_TREBOL, Constantes.COLOR_NEGRO));
        cartas.add(new Carta(8, Constantes.CARTA_TREBOL, Constantes.COLOR_NEGRO));
        cartas.add(new Carta(9, Constantes.CARTA_TREBOL, Constantes.COLOR_NEGRO));
        cartas.add(new Carta(10, Constantes.CARTA_TREBOL, Constantes.COLOR_NEGRO));
        cartas.add(new Carta(11, Constantes.CARTA_TREBOL, Constantes.COLOR_NEGRO));
        cartas.add(new Carta(12, Constantes.CARTA_TREBOL, Constantes.COLOR_NEGRO));
        cartas.add(new Carta(13, Constantes.CARTA_TREBOL, Constantes.COLOR_NEGRO));
        cartas.add(new Carta(14, Constantes.CARTA_TREBOL, Constantes.COLOR_NEGRO));
        
        cartas.add(new Carta(2, Constantes.CARTA_PICA, Constantes.COLOR_NEGRO));
        cartas.add(new Carta(3, Constantes.CARTA_PICA, Constantes.COLOR_NEGRO));
        cartas.add(new Carta(4, Constantes.CARTA_PICA, Constantes.COLOR_NEGRO));
        cartas.add(new Carta(5, Constantes.CARTA_PICA, Constantes.COLOR_NEGRO));
        cartas.add(new Carta(6, Constantes.CARTA_PICA, Constantes.COLOR_NEGRO));
        cartas.add(new Carta(7, Constantes.CARTA_PICA, Constantes.COLOR_NEGRO));
        cartas.add(new Carta(8, Constantes.CARTA_PICA, Constantes.COLOR_NEGRO));
        cartas.add(new Carta(9, Constantes.CARTA_PICA, Constantes.COLOR_NEGRO));
        cartas.add(new Carta(10, Constantes.CARTA_PICA, Constantes.COLOR_NEGRO));
        cartas.add(new Carta(11, Constantes.CARTA_PICA, Constantes.COLOR_NEGRO));
        cartas.add(new Carta(12, Constantes.CARTA_PICA, Constantes.COLOR_NEGRO));
        cartas.add(new Carta(13, Constantes.CARTA_PICA, Constantes.COLOR_NEGRO));
        cartas.add(new Carta(14, Constantes.CARTA_PICA, Constantes.COLOR_NEGRO));
       
        return cartas;
    }
}