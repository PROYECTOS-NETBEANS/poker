package poker.servidor.negocio;

/**
 * 
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class Carta {
    private int nro;
    private Constantes simbolo;
    
    /**
     * Constructor de carta
     * @param nro El valor de la carta
     * @param simbolo El palo al que la carta pertenece
     */
    public Carta(int nro, Constantes simbolo){
        this.nro = nro;
        this.simbolo = simbolo;
    }

    public int getNro() {
        return nro;
    }

    public Constantes getSimbolo() {
        return simbolo;
    }
    
    @Override
    public String toString(){
        return "Carta : " + String.valueOf(nro) + " : " + simbolo ;
    }
}
