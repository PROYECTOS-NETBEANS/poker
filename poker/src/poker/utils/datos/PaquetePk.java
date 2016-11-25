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
        this.data = data;
        this.paquete = pq;        
    }
    public String getData(){
        return this.data;
    }
    public void setData(String data){
        this.data = data;
    }
    
    public TipoPaquete getTipoPaquete(){
        return this.paquete;
    }
    public void setTipoPaquete(TipoPaquete paquete){
        this.paquete = paquete;
    }
}