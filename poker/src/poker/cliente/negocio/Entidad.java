package poker.cliente.negocio;

/**
 * Clase que solo es un modelo para la visualizacion
 * de cualquier objeto en la vista
 * @author LIMBERT
 */
public class Entidad {
    private String value;
    private int key;
    
    public Entidad(String value, int key){
        this.value = value;
        this.key = key;
    }
    public int getKey(){
        return this.key;
    }
    public String getValue(){
        return this.value;
    }  
}
