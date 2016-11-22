package poker.servidor.datos;

/**
 * 
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class Protocolo {
    private int idCliente;
    
    public Protocolo(){
        this.idCliente = 0;
    }
    public int getData(){
        return this.idCliente;
    }
    
    @Override
    public String toString(){
        return "";
    }
}