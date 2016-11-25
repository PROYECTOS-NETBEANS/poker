package poker.servidor.negocio;

import poker.utils.datos.PaquetePk;
import poker.utils.datos.Parser;
import poker.utils.datos.TipoPaquete;

/**
 * 
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class Utils {

    /**
     *Numero maximo de jugadores
     */
    public static final int nroMaximoJugadores = 4;
    
    public Utils(){
        
    }
    public static void main(String[] arg){
        Mesa m = new Mesa(2, 2, 100);
        String stringg = "Hola mundo como estas";
        PaquetePk p = new PaquetePk(stringg, TipoPaquete.MESA);
        
        String data = Parser.objectToString(p);
        System.out.println("mesa : " + data);
    }
}
