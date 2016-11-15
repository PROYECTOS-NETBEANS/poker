
package poker.servidor.negocio;

import java.util.LinkedList;

/**
 * 
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class Casa {
    private int pozoAcumulado = 0;
    private LinkedList<Carta> flop;
    private int idJugDealer = 0;
    private int idJugCiegaPequeña = 0;
    private int idJugCiegaGrande = 0;
    public Casa(){
        this.pozoAcumulado = 0;
        flop = new LinkedList<>();
        this.idJugDealer = 0;
        this.idJugCiegaGrande = 0;
        this.idJugCiegaPequeña = 0;
    }
    
    public void setCarta(Carta c){
        this.flop.add(c);
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