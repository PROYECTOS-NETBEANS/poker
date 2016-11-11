package poker.servidor.negocio;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;
/**
 * 
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class Baraja {
    private Stack<Carta> pila = null;
    
    public Baraja(){
        pila = new Stack<>();
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
    }

    public static void main(String arg[]){
    
        Baraja b = new Baraja();
        b.barajar();
    }
    
    /**
     * Metodo que inicializa con cuantas cartas contara la baraja
     * @return Retorna una lista de cartas inicializadas
     */
    private LinkedList<Carta> inicializarBaraja(){
        LinkedList<Carta> cartas = new LinkedList();
                
        cartas.add(new Carta(2, Constantes.CARTA_CORAZON));
        cartas.add(new Carta(3, Constantes.CARTA_CORAZON));
        cartas.add(new Carta(4, Constantes.CARTA_CORAZON));
        cartas.add(new Carta(5, Constantes.CARTA_CORAZON));
        cartas.add(new Carta(6, Constantes.CARTA_CORAZON));
        cartas.add(new Carta(7, Constantes.CARTA_CORAZON));
        cartas.add(new Carta(8, Constantes.CARTA_CORAZON));
        cartas.add(new Carta(9, Constantes.CARTA_CORAZON));
        cartas.add(new Carta(10, Constantes.CARTA_CORAZON));
        cartas.add(new Carta(11, Constantes.CARTA_CORAZON));
        cartas.add(new Carta(12, Constantes.CARTA_CORAZON));
        cartas.add(new Carta(13, Constantes.CARTA_CORAZON));
        cartas.add(new Carta(14, Constantes.CARTA_CORAZON));

        cartas.add(new Carta(2, Constantes.CARTA_DIAMANTE));
        cartas.add(new Carta(3, Constantes.CARTA_DIAMANTE));
        cartas.add(new Carta(4, Constantes.CARTA_DIAMANTE));
        cartas.add(new Carta(5, Constantes.CARTA_DIAMANTE));
        cartas.add(new Carta(6, Constantes.CARTA_DIAMANTE));
        cartas.add(new Carta(7, Constantes.CARTA_DIAMANTE));
        cartas.add(new Carta(8, Constantes.CARTA_DIAMANTE));
        cartas.add(new Carta(9, Constantes.CARTA_DIAMANTE));
        cartas.add(new Carta(10, Constantes.CARTA_DIAMANTE));
        cartas.add(new Carta(11, Constantes.CARTA_DIAMANTE));
        cartas.add(new Carta(12, Constantes.CARTA_DIAMANTE));
        cartas.add(new Carta(13, Constantes.CARTA_DIAMANTE));
        cartas.add(new Carta(14, Constantes.CARTA_DIAMANTE));
 
        cartas.add(new Carta(2, Constantes.CARTA_TREBOL));
        cartas.add(new Carta(3, Constantes.CARTA_TREBOL));
        cartas.add(new Carta(4, Constantes.CARTA_TREBOL));
        cartas.add(new Carta(5, Constantes.CARTA_TREBOL));
        cartas.add(new Carta(6, Constantes.CARTA_TREBOL));
        cartas.add(new Carta(7, Constantes.CARTA_TREBOL));
        cartas.add(new Carta(8, Constantes.CARTA_TREBOL));
        cartas.add(new Carta(9, Constantes.CARTA_TREBOL));
        cartas.add(new Carta(10, Constantes.CARTA_TREBOL));
        cartas.add(new Carta(11, Constantes.CARTA_TREBOL));
        cartas.add(new Carta(12, Constantes.CARTA_TREBOL));
        cartas.add(new Carta(13, Constantes.CARTA_TREBOL));
        cartas.add(new Carta(14, Constantes.CARTA_TREBOL));
        
        cartas.add(new Carta(2, Constantes.CARTA_PICA));
        cartas.add(new Carta(3, Constantes.CARTA_PICA));
        cartas.add(new Carta(4, Constantes.CARTA_PICA));
        cartas.add(new Carta(5, Constantes.CARTA_PICA));
        cartas.add(new Carta(6, Constantes.CARTA_PICA));
        cartas.add(new Carta(7, Constantes.CARTA_PICA));
        cartas.add(new Carta(8, Constantes.CARTA_PICA));
        cartas.add(new Carta(9, Constantes.CARTA_PICA));
        cartas.add(new Carta(10, Constantes.CARTA_PICA));
        cartas.add(new Carta(11, Constantes.CARTA_PICA));
        cartas.add(new Carta(12, Constantes.CARTA_PICA));
        cartas.add(new Carta(13, Constantes.CARTA_PICA));
        cartas.add(new Carta(14, Constantes.CARTA_PICA));
       
        return cartas;
    }
}