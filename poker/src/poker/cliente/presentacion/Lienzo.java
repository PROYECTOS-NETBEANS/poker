package poker.cliente.presentacion;

import java.awt.Color;
import javax.swing.ImageIcon; 
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import javax.swing.JPanel;
import poker.cliente.negocio.Entidad;
import poker.cliente.negocio.JuegoCliente;
/**
 * Clase donde se generan las mesas que hay en el servidor
 * @author Alex Limbert Yalusqui
 */
public class Lienzo extends JPanel{
    private Image imgMesa = null;
    private File file = null;
    
    private JuegoCliente game;
    
    /* variables privadas para pintar las mesas*/
    private Point pto = new Point(0,0);
    private int ancho = 100;
    private int alto  = 100;
            
    public Lienzo(JuegoCliente game){
        super(true);
        this.game = game;
        this.cargarImagenes();
    }
    
    private void cargarImagenes(){
        //camino donde estan las imagenes
        file = new File("resources");
        imgMesa = (new ImageIcon(file.getAbsolutePath() + "\\lienzo.jpg")).getImage();
    }
    /**
     * Metodo que dibuja una mesa.
     * @param g Grafico para dibujar la mesa
     * @param e Entidad a dibujar para la mesas
     */
    private void pintarMesa(Graphics g, Entidad e){
        g.drawImage(imgMesa, pto.x + 10, pto.y + 10, 100, 100, null);
        g.setColor(Color.WHITE);
        g.drawString("Mesa # 1", 30, 60);
        
    }
    /**
     * Metodo que dibuja todas las mesas que tiene en el servidor
     * @param g Grafico para dibujar la mesa
     */
    private void pintarMesas(Graphics g){
        // aqui tengo que recorrer las mesas del negocio
        this.pintarMesa(g, new Entidad("Mesa # 1", 2));
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paint(g);
        if(imgMesa != null){            
            this.pintarMesas(g);
        }
    }
}