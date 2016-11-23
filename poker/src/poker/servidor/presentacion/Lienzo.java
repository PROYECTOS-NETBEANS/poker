package poker.servidor.presentacion;

import java.awt.Color;
import javax.swing.ImageIcon; 
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import javax.swing.JPanel;
import jsocket.client.OnConnectedEventClient;
import jsocket.client.OnConnectedListenerClient;
/**
 * 
 * @author LIMBERT
 */
public class Lienzo extends JPanel implements OnConnectedListenerClient{
    private Image imgMesa = null;
    private File file = null;
    
    public Lienzo(){
        super(true);
        this.cargarImagenes();
    }
    
    private void cargarImagenes(){
        //camino donde estan las imagenes
        file = new File("resources");
        imgMesa = (new ImageIcon(file.getAbsolutePath() + "\\lienzo.jpg")).getImage();
    }
    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        if(imgMesa != null){
            g.drawImage(imgMesa, 10, 10, 100, 100, null);
            g.setColor(Color.WHITE);
            g.drawString("Mesa # 1", 30, 60);
        }
    }

    @Override
    public void onConnect(Object o, OnConnectedEventClient ocec) {
        System.out.println("on conect no implementado");
    }

    @Override
    public void onDisconnect(Object o, OnConnectedEventClient ocec) {
        System.out.println("on Disconnect no implementado");
    }

    @Override
    public void onRead(Object o, OnConnectedEventClient ocec) {
        //Verificar los datos que llegan y segun el tipo de datos proceder
        
    }

    @Override
    public void onConnectRefused() {
        System.out.println("on conectRefused no implementado");
    }

    @Override
    public void onConnectFinally() {
        System.out.println("on connect Finally no implementado");
    }
}