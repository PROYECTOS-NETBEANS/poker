package poker.utils.datos;

import com.google.gson.Gson;

/**
 *
 * @author LIMBERT
 */
public class Parser{
    
    public Parser(){

    }
    /**
     * Genera un String a partir de un objeto
     * @param obj El objeto que se va a serializar
     * @return Retorna una cadena
     */
    public static String objectToString(Object obj){
        Gson g = new Gson();
        String data = g.toJson(obj);
        
        return data;
    }
    /**
     * Metodo que genera un objeto a partir de un string
     * @param data El string que llega 
     * @param clase El tipo de objeto el que devolvera el metodo
     * @return Retorna un objeto ya definido
     */
    public static Object stringToObject(String data, Class clase){
        Gson g = new Gson();
        Object obj = g.fromJson(data, clase);
        return obj;
    }
}
