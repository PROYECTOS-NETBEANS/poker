package poker.servidor.presentacion;

import javax.swing.ImageIcon; 
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JPanel;

/**
 *
 * @author LIMBERT
 */
public class Lienzo extends JPanel{
    private Image img = null;   
    
    public Lienzo(){
        super(true);
    }
    
    public void cargarImagen(ImageIcon ico){
        img = ico.getImage();        
    }
    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        if(img != null){
            g2.drawImage(img, 10, 10, 100, 100, null);
        }

    }   
}
