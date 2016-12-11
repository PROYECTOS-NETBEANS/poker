/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package poker.servidor.negocio;

import java.util.LinkedList;

/**
 * Clase donde estan las cartas que tienen en su mano cada usuario 
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class ManoPoker {
    /**
     * Mano donde se encuentran las cartas de la persona
     */
    private LinkedList<Carta> mano = null;
    /**
     * Identificador primario a cual pertenece esta mano de poker
     */
    private int idJugador = 0;
    
    public ManoPoker(int idJugador){
        this.mano = new LinkedList<>();
        this.idJugador = idJugador;
    }
    /**
     * Metodo que adiciona una carta a la mano del jugador
     * @param c Carta que se va adicionar
     */
    public void setCarta(Carta c){
        this.mano.add(c);
    }
    /**
     * Metodo que devuelve el id de jugador a cual pertenece la mano
     * @return identificador unico de jugador
     */
    public int getIdJugador(){
        return this.idJugador;
    }
    /**
     * Metodo que devuelve el numero de cartas que tiene en su mano
     * @return Nro de cartas
     */
    public int nroCartas(){
        return this.mano.size();
    }
    /**
     * Metodo que devuelve una carta de la mano
     * @param i Posicion de la carta a retornar
     * @return Carta que se encuentra en la posicion i,
     */
    public Carta getCarta(int i){
        return this.mano.get(i);
    }
    /**
     * Elimina una carta de la posicion indicada
     * @param i Posicion donde se encuentra la carta a eliminar
     */
    public void removeCarta(int i){
        this.mano.remove(i);
    }
    /**
     * Devuelve una carta y elimina de la lista
     * @param nroCarta Es el numero de carta que se esta buscando
     * @return devulve nulo si no encuentra la carta
     */
    public Carta getCartaRemove(int nroCarta){
        try{
            for (Carta carta : mano) {
                if(nroCarta == carta.getNro()){
                    this.mano.remove(carta);
                    return carta;
                }
            }
        return null;
        }catch(Exception e){
            System.out.println("[ManoPoker.getCartaRemove]");
            return null;
        }
    }
}