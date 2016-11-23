package poker.cliente.negocio;
import java.util.HashMap;
import poker.servidor.negocio.Mesa;
import poker.utils.datos.*;
/**
 * 
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class Analizador {
    
    public Analizador(){
    }
    
    public void analizarPaquete(PaquetePk p){
        switch(p.getTipoPaquete()){
            case LISTA_MESAS:
                this.listaMesas(p.getData());
                break;
            case LISTA_JUGADORES:
                System.out.println("nada");
                break;
        }
    }
    private void listaMesas(String data){
         HashMap<Integer, Mesa> mesas = (HashMap) Parser.stringToObject(data, HashMap.class);
         
    }
    private void nuevoJugador(String data){
        
    }
}
