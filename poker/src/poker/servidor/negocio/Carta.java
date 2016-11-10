package poker.servidor.negocio;

/**
 * 
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class Carta {
    private int nro;
    private int simbolo;
    private String color;
    
    /**
     * Constructor de carta
     * @param nro El valor de la carta
     * @param simbolo El palo al que la carta pertenece
     * @param color El color de la carta
     */
    public Carta(int nro, int simbolo, String color){
        this.nro = nro;
        this.simbolo = simbolo;
        this.color = color;
    }

    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public int getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(int simbolo) {
        this.simbolo = simbolo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
}
