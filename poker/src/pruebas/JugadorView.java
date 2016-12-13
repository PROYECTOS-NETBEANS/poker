package pruebas;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import poker.servidor.datos.Jugador;
import poker.utils.datos.Constantes;

/**
 *
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class JugadorView extends javax.swing.JPanel {

    public Jugador jugador = null;
    /**
     * Creates new form JugadorView
     * @param jg Jugador a cual pertenece esta vista
     */
    public JugadorView(Jugador jg) {
        try {
            initComponents();
            this.iniciar(jg);
        } catch (Exception e) {
            System.out.println("[JugadorView.JugadorView]" + e.getMessage());
        }
    }
    private void iniciar(Jugador j){
        try {
            this.jugador = j;
            this.lNombreJugador.setText(this.jugador.getNickName().toUpperCase());            
            this.lMonto.setText("Monto act. : " + String.valueOf(this.jugador.getMonto()));
        } catch (Exception e) {
            System.out.println("[JugadorView.iniciar] " + e.getMessage());
        }

    }
    public void actualizarDatos(int monto, Constantes tipoJug, Constantes estadoConex, Constantes turno){
        this.lMonto.setText("Monto act. : " + String.valueOf(monto));
        this.updateComponentes();
    }
    private void updateComponentes(){
        ImageIcon image;
        Icon ico;
        if(this.jugador.TURNO == Constantes.TURNO_TOCA)
            image = new ImageIcon(getClass().getResource("/poker/activo.png"));
        else{
            image = new ImageIcon(getClass().getResource("/poker/inactivo.png"));
        }
        //ico = new ImageIcon(image.getImage().getScaledInstance(WIDTH, HEIGHT, Image.ESCALE_DEFAULT))
        ico = new ImageIcon(image.getImage());
        this.lTurno.setIcon(ico);
        // ahora cambiamos el icono de tipo jugador
        switch(this.jugador.TIPO_JUGADOR){
            case TIPO_CIEGA_GRANDE:
                image = new ImageIcon(getClass().getResource("/poker/cg.png"));
                break;
            case TIPO_CIEGA_PEQUE�A:
                image = new ImageIcon(getClass().getResource("/poker/cp.png"));
                break;
            case TIPO_DEALER:
                image = new ImageIcon(getClass().getResource("/poker/dealer.png"));
                break;
            case TIPO_NORMAL:
                image = new ImageIcon(getClass().getResource("/poker/normal.png"));
                break;          
        }
        ico = new ImageIcon(image.getImage());
        this.lTipo.setIcon(ico);
        
        // ahora cambiamos el estado de conexion
        switch(this.jugador.ESTADO_CONEXION){
            case ESTADO_CONECTADO:
                image = new ImageIcon(getClass().getResource("/poker/avatar1.png"));
                break;
            case ESTADO_DESCONECTADO:
                image = new ImageIcon(getClass().getResource("/poker/avatar1.png"));
                break;
            case ESTADO_RETIRADO:
                image = new ImageIcon(getClass().getResource("/poker/avatar1.png"));
                break;
        }
        ico = new ImageIcon(image.getImage());
        this.lTipo.setIcon(ico);
        
        // finalmente actualizamos el componente
        this.updateUI();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lNombreJugador = new javax.swing.JLabel();
        lMonto = new javax.swing.JLabel();
        ljugador = new javax.swing.JLabel();
        lcarta2 = new javax.swing.JLabel();
        lcarta1 = new javax.swing.JLabel();
        lavatar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lTurno = new javax.swing.JLabel();
        lTipo = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 51, 51));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lNombreJugador.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lNombreJugador.setForeground(new java.awt.Color(240, 240, 240));
        lNombreJugador.setText("JUGADOR XXX");
        add(lNombreJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 80, -1));

        lMonto.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lMonto.setForeground(new java.awt.Color(240, 240, 240));
        lMonto.setText("Monto Act. : 1000");
        add(lMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, -1, -1));

        ljugador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poker/cartas/logo.png"))); // NOI18N
        add(ljugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 200, 90));

        lcarta2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poker/cartas/atras.jpg"))); // NOI18N
        add(lcarta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 70, 100));

        lcarta1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lcarta1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poker/cartas/atras.jpg"))); // NOI18N
        add(lcarta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, -1, -1));

        lavatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poker/cartas/avatar1.png"))); // NOI18N
        add(lavatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 90, 80));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Apuesta : 20 $");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 90, 20));

        lTurno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poker/cartas/inactivo.png"))); // NOI18N
        add(lTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, 80));

        lTipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poker/cartas/normal.png"))); // NOI18N
        add(lTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnverdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnverdeActionPerformed
        
    }//GEN-LAST:event_btnverdeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lMonto;
    private javax.swing.JLabel lNombreJugador;
    private javax.swing.JLabel lTipo;
    private javax.swing.JLabel lTurno;
    private javax.swing.JLabel lavatar;
    private javax.swing.JLabel lcarta1;
    private javax.swing.JLabel lcarta2;
    private javax.swing.JLabel ljugador;
    // End of variables declaration//GEN-END:variables
}
