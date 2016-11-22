package poker.servidor.negocio;
import poker.utils.datos.*;
/**
 * 
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class Carta {
    private int nro;
    private Constantes simbolo;
    private Constantes color;
    
    /**
     * Constructor de carta
     * @param nro El valor de la carta
     * @param simbolo El palo al que la carta pertenece
     */
    public Carta(int nro, Constantes simbolo, Constantes color){
        this.nro = nro;
        this.simbolo = simbolo;
        this.color = color;
    }

    public int getNro() {
        return nro;
    }

    public Constantes getSimbolo() {
        return simbolo;
    }
    public Constantes getColor(){
        return this.color;
    }
    @Override
    public String toString(){
        return "Carta : " + String.valueOf(nro) + " : " + simbolo;
    }
}
