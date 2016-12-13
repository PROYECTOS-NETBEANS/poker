package poker.servidor.datos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class Archivo {
    private FileOutputStream fileOut = null;
    private ObjectOutputStream salida = null;
    
    private FileInputStream fileIn = null;
    private ObjectInputStream entrada = null;

    private HashMap<Integer, Jugador> jugadores = null;
    private int keyValue = 1;
    
    public Archivo(){
        jugadores = new HashMap<>();
        
    }
    /**
     * Metodo que guarda el jugador al archivo
     * @param o Jugador a guardarse
     * @return Identificador unico del jugador que se genero al guardar
     */
    public int guardarJugador(Jugador o){
        try {
            //primero obtenemos la coleccion de jugadores
            this.getJugadoresBd();
            
            o.setId(keyValue);
            keyValue++;
            
            jugadores.put(o.getId(), o);
            
            fileOut = new FileOutputStream("jugadores.db");
            try {
                salida = new ObjectOutputStream(fileOut);               
                salida.writeObject(jugadores);
                // Este es la llave primaria que es unica
                salida.writeInt(keyValue);
                salida.close();
                return o.getId();
            } catch (IOException ex) {
                System.out.println("[Error : Archivo.guardarObject 1] : " + ex.getMessage());
                return -1;
            }
        } catch (FileNotFoundException ex) {
                System.out.println("[Error : Archivo.guardarObject 2] : " + ex.getMessage());
                return -1;
        }        
    }
    /**
     * Metodo que obtiene la lista de jugadores del servidor
     */
    private void getJugadoresBd(){
        try {
            fileIn = new FileInputStream("jugadores.db");
            try {
                entrada = new ObjectInputStream(fileIn);
                try {
                    jugadores = (HashMap<Integer, Jugador>) entrada.readObject();
                    keyValue  = entrada.readInt();
                    this.toStringJugadores();
                } catch (ClassNotFoundException ex) {
                    System.out.println("[Archivo.leerJugador] : " + ex.getMessage());
                }               
                
            } catch (IOException ex) {
                System.out.println("[Error : Archivo.guardarObject 1] : " + ex.getMessage());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("[Error : Archivo.leerObject] : " + ex.getMessage());
        }
        
    }
    /**
     * Devuelve un jugador a partir de la llave primaria
     * @param id Identifacador unico de jugador
     * @return Objeto jugador recuperado de la bd.
     */
    public Jugador getJugador(int id){
       this.getJugadoresBd();
       return jugadores.get(id);
    }
    /**
     * Metodo que devuelve un jugador a partir del nombre de usuario
     * @param nick Nombre de usuario
     * @return Objeto jugador con todas sus confuguraciones
     */
    public Jugador getJugador(String nick){
        this.getJugadoresBd();
        return this.nickIgual(nick);
    }
    
    private Jugador nickIgual( String nick){
        for (Map.Entry data : jugadores.entrySet()) {
            Jugador jg = (Jugador) data.getValue();
            if(jg.getNickName().equals(nick)){
                return jg;
            }            
        }
        return null;
    }    
    private void toStringJugadores(){
        for (Map.Entry data : jugadores.entrySet()) {
            Jugador jg = (Jugador) data.getValue();
            System.out.println(jg.toString());
        }        
    }
}