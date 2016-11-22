package poker.utils.datos;

import java.io.Serializable;

/**
 * 
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class PaquetePk implements Serializable{
    private TipoPaquete paquete = null;
    private String data = "";
    public PaquetePk(String data, TipoPaquete pq){
        this.data = "";
        this.paquete = pq;        
    }
    public String getData(){
        return this.data;
    }
    public TipoPaquete getTipoPaquete(){
        return this.paquete;
    }
    @Override
    public String toString(){
        return "";
    }
}