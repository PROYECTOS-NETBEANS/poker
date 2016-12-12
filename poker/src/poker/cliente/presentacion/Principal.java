/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker.cliente.presentacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import poker.cliente.negocio.PokerClient;
/**
 *
 * @author LIMBERT
 */
public class Principal extends javax.swing.JFrame implements ActionListener{
    private PokerClient cliente = null;
    private Clientesymesas p =null;
    private mesajuego m = null;
    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
      // this.setLocationRelativeTo(null);
       this.setSize(1500, 800);
        iniciador();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(450, 350));
        setMinimumSize(new java.awt.Dimension(450, 350));
        setPreferredSize(new java.awt.Dimension(450, 350));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 434, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 367, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
    
    private void iniciador(){
        String nickName = JOptionPane.showInputDialog("Ingrese un nickName : ", "pedro");
       
        if(nickName.length() > 0 ){
            cliente = new PokerClient(5555, "localhost");
            cliente.conectarServidor(nickName);
            cargarjug_mesa();
             
        } 
    }

    public  void cargarjug_mesa(){
            p= new Clientesymesas(cliente,this);
            cliente.addEventListenerPackages(p);
            p.setBounds(1, 1, this.getWidth() - 10, this.getHeight() - 10);
            p.setVisible(true);
            this.getContentPane().add(p);
            //this.setSize(450,350);
            
            
             m = new mesajuego(cliente,this);
             m.setBounds(1, 1, this.getWidth() - 10, this.getHeight() - 10);
             m.setVisible(false);
             this.getContentPane().add(m);
           
    } 
 
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getActionCommand().equals("btnverde")){
                System.out.println("me presionaron en el panel verde");
                this.setSize(1100, 650);
                this.setLocation(70, 50);
                p.setVisible(false);
                m.setVisible(true);
                this.repaint();
                
                System.out.println("pase el verde");
                
            }else{
                if(e.getActionCommand().equals("btnrojo")){
                    this.setSize(450, 350);
                    this.setLocationRelativeTo(null);
                    m.setVisible(false);
                    p.setVisible(true);
                    this.repaint();
                    

                }
            }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
