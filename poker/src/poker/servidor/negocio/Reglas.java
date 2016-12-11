package poker.servidor.negocio;

/**
 * Clase que aplica las reglas y verifica cual es la mano ganadora
 * Para el tipo de poker Texas Hold'em 
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class Reglas {
    
    /**
     * Constructor de la clase para aplicacion de reglas
     */
    public Reglas(){
        
    }
        
    private boolean isEscaleraReal(ManoPoker mJugador, ManoPoker mHouse){
        try{
            Carta c = null;
            int i = 0;
            ManoPoker mJg = mJugador;
            ManoPoker mho = mHouse;
            
            while(i < mJg.nroCartas()){
                c = mJg.getCarta(i);
                
                i++;
            }
            return true;
        }catch(Exception e){
            System.out.println("[Reglas.isEscalera]" + e.getMessage());
            return false;
        }
    }
    /**
     * Devuelve una carta de la mano de jugador o la mesa
     * @param mj Mano de cartas del jugador
     * @param mh Mano de cartas de la mesa
     * @param nroCarta Es la carta que se esta buscando
     * @return Devuelve la carta, si no encuentra devuelve nulo.
     */
    private Carta getCartaFromMano(ManoPoker mj, ManoPoker mh, int nroCarta){
        try{
            
            Carta c = mj.getCartaRemove(nroCarta);
            if(c == null){
                c = mh.getCartaRemove(nroCarta);
            }
            return c;
        }catch(Exception e){
            System.out.println("[Reglas.getCartaFromMano]" + e.getMessage());
            return null;
        }
    }
    /**
     * Metodo que verifica si tiene un poker en sus mano
     * @param mJugador Mano del jugador
     * @param mHouse Mano de la casa
     * @return Retornoa 0 si no tiene un poker , 
     * caso contrario retorna el nro con el cual se realizó el poker 
     */
    private int isPoker(ManoPoker mJugador, ManoPoker mHouse){
        return -1;
    }
}
