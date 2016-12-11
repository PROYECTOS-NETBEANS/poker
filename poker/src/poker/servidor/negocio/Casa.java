
package poker.servidor.negocio;

import java.util.LinkedList;

/**
 * 
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class Casa {
    private int pozoAcumulado = 0;
    /**
     * Lista de las cartas que estan en la mesa
     */
    private ManoPoker flop;
    private int idJugDealer = 0;
    private int idJugCiegaPequeña = 0;
    private int idJugCiegaGrande = 0;
    public Casa(){
        this.pozoAcumulado = 0;
        flop = new ManoPoker(-1);
        this.idJugDealer = 0;
        this.idJugCiegaGrande = 0;
        this.idJugCiegaPequeña = 0;
    }
    /**
     * Adiciona una carta a la mesa (es decir al flop)
     * @param c Carta que se adiciona a la mesa
     */
    public void setCarta(Carta c){
        this.flop.setCarta(c);
    }
    /**
     * Metodo que devuelve la mano que hay en la mesa
     * @return 
     */
    public ManoPoker getFlop(){
        return this.flop;
    }
    
    public void subirApuesta(int pozo){
        this.pozoAcumulado = pozo;
    }
    public void setCiegaGrande(int idJug){
        this.idJugCiegaGrande = idJug;
    }
    public void setCiegaPequeña(int idJug){
        this.idJugCiegaPequeña = idJug;
    }
    public void setDealer(int idJug){
        this.idJugDealer = idJug;
    }    
}