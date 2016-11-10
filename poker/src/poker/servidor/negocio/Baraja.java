package poker.servidor.negocio;
import java.util.Stack;
/**
 * 
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class Baraja {
    private Stack<Carta> pila;
    
    public Baraja(){
        pila = new Stack<>();
    }
    
    public void setCarta(Carta carta){
        pila.push(carta);
    }
    
    public Carta getCarta(){
        if(!pila.empty()){
            return this.pila.pop();
        }else{
            return null;
        }
    }
    
}
