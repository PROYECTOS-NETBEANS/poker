package pruebas;

import java.awt.Point;
import java.util.HashMap;
import javax.swing.JPanel;
import poker.cliente.negocio.PokerClient;
import poker.servidor.datos.Jugador;

/**
 *
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class GameView extends JPanel {

    private PokerClient cliente = null;
    
    /**
     * Punto inicial desde donde se inicia.
     */
    private Point punto = null;
    /**
     * Es el espaciado entre cada panel de jugador
     */
    private int espaciado = 10;
    
    private final int anchoPanel = 201;
    private final int altoPanel = 130;
    
    /**
     * Lista de todos los jugadores <IdJugador, Panel>
     */
    private HashMap<Integer, JPanel> vJugadores = null;
    /**
     * Creates new form panelPrueba
     * @param cliente Cliente
     */
    public GameView(PokerClient cliente) {
        initComponents();
        this.inicializar(cliente);
    }
    private void inicializar(PokerClient cliente){
        this.cliente = cliente;
        this.punto = new Point(0, 10);
        this.vJugadores = new HashMap<>();
    }
    private void calcularPuntos(){
        this.punto.x = (this.espaciado * (vJugadores.size() + 1)) + ((vJugadores.size()) * anchoPanel);
        // punto en y no se esta calculando
    } 
    private void addJugador(Jugador jg){
        JugadorView v = new JugadorView(jg);
        this.calcularPuntos();
        v.setBounds(punto.x, punto.y, anchoPanel, altoPanel);
        v.setVisible(true);    
        this.add(v);    
        this.updateUI();
        this.vJugadores.put(jg.getId(), v);        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 0, 0));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(568, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(173, 173, 173))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(375, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Jugador x = new Jugador("limbert", 2999, "M");
        x.setId(1);
        this.addJugador(x);        
        x = new Jugador("limbert", 2999, "M");
        x.setId(3);
        this.addJugador(x);                
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
