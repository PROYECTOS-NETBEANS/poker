/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.awt.event.ActionListener;

/**
 *
 * @author Alex Limbert Yalusqui <limbertyalusqui@gmail.com>
 */
public class JugadorView extends javax.swing.JPanel {

    /**
     * Creates new form JugadorView
     * @param lst
     */
    public JugadorView(ActionListener lst) {
        initComponents();
        btnverde.addActionListener(lst);
        btnverde.setActionCommand("btnverde");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lcarta2 = new javax.swing.JLabel();
        lcarta1 = new javax.swing.JLabel();
        btnverde = new javax.swing.JButton();

        setBackground(new java.awt.Color(51, 255, 51));

        lcarta2.setText("carta2");

        lcarta1.setText("carta1");

        btnverde.setText("jButton1");
        btnverde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnverdeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addComponent(btnverde)
                .addGap(61, 61, 61)
                .addComponent(lcarta1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(lcarta2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lcarta2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnverde)
                    .addComponent(lcarta1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(102, 102, 102))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnverdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnverdeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnverdeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnverde;
    private javax.swing.JLabel lcarta1;
    private javax.swing.JLabel lcarta2;
    // End of variables declaration//GEN-END:variables
}
