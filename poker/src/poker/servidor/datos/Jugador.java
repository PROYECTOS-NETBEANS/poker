package poker.servidor.datos;

import java.io.Serializable;
import poker.utils.datos.Constantes;

/**
 * 
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class Jugador implements Serializable{
    private int id = 0;
    private String nickName = "";
    private int Monto = 0;
    private String sexo = "";
    private Constantes TIPO_JUGADOR = Constantes.TIPO_NORMAL;
    private Constantes ESTADO_CONEXION = Constantes.ESTADO_CONECTADO;
    private Constantes TURNO = Constantes.TURNO_NO_TOCA;

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
        this.id = -1;
        this.TIPO_JUGADOR = Constantes.TIPO_NORMAL;
        this.ESTADO_CONEXION = Constantes.ESTADO_CONECTADO;
        this.TURNO = Constantes.TURNO_NO_TOCA;
    }
    /**
     * Cambia el estado del tipo de jugador
     * @param tipo Tipo de jugador Dealer, ciega, etc.
     */
    public void setTipoJugador(Constantes tipo){
        this.TIPO_JUGADOR = tipo;
    }
    public Constantes getTipoJugador(){
        return this.TIPO_JUGADOR;
    }
    /**
     * Cambia el estado de la conexion del jugador
     * @param estado Estado de la conexion conectado, desconectado, etc.
     */
    public void setEstadoJugador(Constantes estado){
        this.ESTADO_CONEXION = estado;
    }
    public Constantes getEstadoJugador(){
        return this.ESTADO_CONEXION;
    }
    /**
     * Cambia el turno del jugador
     * @param turno Turno del jugador , si le toca hacer su jugada
     */
    public void setTurnoJugador(Constantes turno){
        this.TURNO = turno;
    }
    public Constantes getTurnoJugador(){
        return this.TURNO;
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
    @Override
    public String toString(){
        return "jugador : " + String.valueOf(id) + ", " + this.nickName + ", " + this.sexo;
    }
}