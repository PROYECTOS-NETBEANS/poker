package poker.servidor.datos;

import java.io.Serializable;

/**
 * 
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class Jugador implements Serializable{
    private int id = 0;
    private String nickName = "";
    private int Monto = 0;
    private String sexo = "";
    /**
     * True si el jugador esta conectado falso en otro caso.
     */
    private boolean estadoConexion = true;
    /**
     * Nuevo jugador 
     * @param nick nombre de usuario de jugador
     * @param monto monto (Dinero) con lo que se apostara.
     * @param sexo Sexo del jugador
     */
    public Jugador(String nick, int monto, String sexo){
        this.nickName = nick;
        this.Monto = monto;
        this.sexo = sexo;
        this.estadoConexion = true;
        this.id = -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getMonto() {
        return Monto;
    }

    public void setMonto(int Monto) {
        this.Monto = Monto;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public boolean isEstadoConexion() {
        return estadoConexion;
    }
    
    public void setEstadoConexion(boolean estadoConexion) {
        this.estadoConexion = estadoConexion;
    }
    @Override
    public String toString(){
        return "jugador : " + String.valueOf(id) + ", " + this.nickName + ", " + this.sexo;
    }
}