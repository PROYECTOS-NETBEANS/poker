package poker.cliente.presentacion;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.ImageIcon; 
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JPanel;
import poker.servidor.negocio.Mesa;
import java.util.Observable;
import java.util.Observer;
import poker.cliente.negocio.PokerClient;
/**
 * Clase donde se generan las mesas que hay en el servidor
 * @author Alex Limbert Yalusqui
 */
public class Lienzo extends JPanel implements MouseMotionListener, MouseListener, Observer{
    private Image imgMesa = null;
    private File file = null;
    
    private PokerClient cliente = null;
    
    /* variables privadas para pintar las mesas*/
    private Point pto = new Point(0,0);
    private int ancho = 100;
    private int alto  = 100;
    
    private int nroColumna = 0;
    private int nroFila = 0;
    
    private HashMap<Integer, Rectangle> ms;
    
    public Lienzo(PokerClient cliente){
        super(true);
        this.cliente = cliente;
        this.cargarImagenes();
        ms = new HashMap<>();
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
    private void pintarMesa(Graphics g, Mesa m){
        
        g.drawImage(imgMesa, pto.x, pto.y , ancho, alto, null);
        g.drawRect(pto.x, pto.y, ancho, alto);
        System.out.println("(" + String.valueOf(pto.x) + "," + String.valueOf(pto.y) + ")");
        g.setColor(Color.WHITE);
        g.drawString("MESA # " + String.valueOf(m.getId()), pto.x + 30, pto.y + 60);
        
    }
    /**
     * Metodo que dibuja todas las mesas que tiene en el servidor
     * @param g Grafico para dibujar la mesa
     */
    private void pintarMesas(Graphics g){
        // aqui tengo que recorrer las mesas del negocio
        HashMap<Integer, Mesa> mesas = cliente.getMesas();
        int i = 1;
        if(mesas != null){
            Iterator<Mesa> it = mesas.values().iterator();
            System.out.println("count " + String.valueOf(mesas.size()));
            this.iniciarPuntos();
            while(it.hasNext()) {
                Mesa m = (Mesa) it.next();
                this.calcularPuntos(m.getId());
                this.pintarMesa(g, m);
                i = i + 1;
            }            
        }

    }
    private void iniciarPuntos(){
        this.nroFila = 1;
        this.nroColumna = 1;
        this.pto.x = 0;
        this.pto.y = 0;
    }
    private void calcularPuntos(int id){

        pto.x = (10 * (nroColumna)) + (ancho * (nroColumna - 1));
        pto.y = (10 * (nroFila)) + (alto * (nroFila - 1));
        
        ms.put(id, new Rectangle(pto, new Dimension(ancho, alto)));
        
        if(nroColumna > 3){ // si es mayor a cero aumentamos fila
            nroFila = nroFila + 1;
            nroColumna = 1; 
        }else{
            nroColumna = nroColumna + 1;            
        }

    }
    @Override
    protected void paintComponent(Graphics g){
        if(imgMesa != null){
            this.pintarMesas(g);
        }
    }
    
    @Override
    public void mouseMoved(MouseEvent e) {
        if(estaContenido(e.getPoint()) > 0 ){
            if(this.getCursor().getType() != Cursor.HAND_CURSOR){
                this.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }           
        }else{
            if(this.getCursor().getType() != Cursor.DEFAULT_CURSOR){
                this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        }
    }
    /**
     * Metodo que devuelve true si el punto esta dentro de una mesa
     */
    private int estaContenido(Point p){
        int estado = 0;
        
        for (Map.Entry<Integer, Rectangle> entry : ms.entrySet()) {            
            Rectangle value = entry.getValue();
            int key = entry.getKey();
            if(value.contains(p)){
                estado = key;
            }
        }
        return estado;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int k = estaContenido(e.getPoint());
        if(k > 0){
            //cliente.ingresarMesa(k);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Se modifico el negocio!");
        this.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
     @Override
    public void mouseDragged(MouseEvent e) {}  
}