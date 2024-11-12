/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Giancarlo
 */
public class panelTienda extends javax.swing.JPanel {

    /**
     * Creates new form panelTienda
     */
    public panelTienda() {
        initComponents();
    }
    
    private void ShowJPanel(JPanel ti){
        ti.setSize(1280, 620);
        ti.setLocation(0, 0);
        panelInicio.removeAll();
        panelInicio.add(ti, BorderLayout.CENTER);
        panelInicio.revalidate();
        panelInicio.repaint(); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnCarrito = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButtonInicio = new javax.swing.JButton();
        jButtonNovedades = new javax.swing.JButton();
        jButtonMasVendidos = new javax.swing.JButton();
        jButtonZonaGamer = new javax.swing.JButton();
        jButtonArmaTuPc = new javax.swing.JButton();
        jButtonOferta = new javax.swing.JButton();
        panelInicio = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(1280, 720));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));

        jPanel2.setBackground(new java.awt.Color(0, 0, 204));
        jPanel2.setPreferredSize(new java.awt.Dimension(1280, 60));

        btnCarrito.setBackground(new java.awt.Color(0, 0, 204));
        btnCarrito.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        btnCarrito.setForeground(new java.awt.Color(255, 255, 255));
        btnCarrito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carritoAzul25x25.jpg"))); // NOI18N
        btnCarrito.setText("VER CARRITO");
        btnCarrito.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 0, 0
        )));
        btnCarrito.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCarrito.setIconTextGap(10);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logoPequeño 50x41.jpg"))); // NOI18N

        btnSalir.setBackground(new java.awt.Color(0, 0, 204));
        btnSalir.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salida (1).png"))); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 0, 0
        )));
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.setIconTextGap(10);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addGap(729, 729, 729)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13))
        );

        jPanel3.setBackground(new java.awt.Color(0, 255, 0));
        jPanel3.setPreferredSize(new java.awt.Dimension(1280, 40));

        jComboBox1.setBackground(new java.awt.Color(0, 255, 0));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "INICIO", "NOVEDADES", "OFERTA", "MÁS VENDIDOS", "ZONA  GAMER", "ARMA TU PC", "QUIENES SOMOS", "SERVICIO AL CLIENTE" }));
        jComboBox1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 0, 0)));
        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButtonInicio.setBackground(new java.awt.Color(0,0,0,0));
        jButtonInicio.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        jButtonInicio.setText("INICIO");
        jButtonInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInicioActionPerformed(evt);
            }
        });

        jButtonNovedades.setBackground(new java.awt.Color(0,0,0,0));
        jButtonNovedades.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        jButtonNovedades.setText("NOVEDADES");
        jButtonNovedades.setToolTipText("");
        jButtonNovedades.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonNovedades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovedadesActionPerformed(evt);
            }
        });

        jButtonMasVendidos.setBackground(new java.awt.Color(0,0,0,0));
        jButtonMasVendidos.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        jButtonMasVendidos.setText("MÁS VENDIDOS");
        jButtonMasVendidos.setToolTipText("");
        jButtonMasVendidos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonMasVendidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMasVendidosActionPerformed(evt);
            }
        });

        jButtonZonaGamer.setBackground(new java.awt.Color(0,0,0,0));
        jButtonZonaGamer.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        jButtonZonaGamer.setText("ZONA GAMER");
        jButtonZonaGamer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonZonaGamer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonZonaGamerActionPerformed(evt);
            }
        });

        jButtonArmaTuPc.setBackground(new java.awt.Color(0,0,0,0));
        jButtonArmaTuPc.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        jButtonArmaTuPc.setText("ARMA TU PC");
        jButtonArmaTuPc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonArmaTuPc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonArmaTuPcActionPerformed(evt);
            }
        });

        jButtonOferta.setBackground(new java.awt.Color(0,0,0,0));
        jButtonOferta.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        jButtonOferta.setText("OFERTA");
        jButtonOferta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonOferta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOfertaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonNovedades, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonMasVendidos, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonZonaGamer, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonArmaTuPc, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonNovedades, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonMasVendidos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonZonaGamer, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonArmaTuPc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelInicio.setBackground(new java.awt.Color(0, 204, 204));
        panelInicio.setPreferredSize(new java.awt.Dimension(1280, 620));

        javax.swing.GroupLayout panelInicioLayout = new javax.swing.GroupLayout(panelInicio);
        panelInicio.setLayout(panelInicioLayout);
        panelInicioLayout.setHorizontalGroup(
            panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1278, Short.MAX_VALUE)
        );
        panelInicioLayout.setVerticalGroup(
            panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 505, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        //
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButtonInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInicioActionPerformed
        //ShowJPanel(new TablaCliente());
    }//GEN-LAST:event_jButtonInicioActionPerformed

    private void jButtonNovedadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovedadesActionPerformed
        ShowJPanel(new TiendaNovedades());
    }//GEN-LAST:event_jButtonNovedadesActionPerformed

    private void jButtonMasVendidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMasVendidosActionPerformed
        ShowJPanel(new TiendaMasVendido());
    }//GEN-LAST:event_jButtonMasVendidosActionPerformed

    private void jButtonZonaGamerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonZonaGamerActionPerformed
        ShowJPanel(new TiendaZonaGamer());
    }//GEN-LAST:event_jButtonZonaGamerActionPerformed

    private void jButtonArmaTuPcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonArmaTuPcActionPerformed
        ShowJPanel(new TiendaArmaTuPc());
    }//GEN-LAST:event_jButtonArmaTuPcActionPerformed

    private void jButtonOfertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOfertaActionPerformed
        ShowJPanel(new TiendaOferta());//ShowJPanel(new Producto1());
    }//GEN-LAST:event_jButtonOfertaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCarrito;
    public javax.swing.JButton btnSalir;
    private javax.swing.JButton jButtonArmaTuPc;
    private javax.swing.JButton jButtonInicio;
    private javax.swing.JButton jButtonMasVendidos;
    private javax.swing.JButton jButtonNovedades;
    private javax.swing.JButton jButtonOferta;
    private javax.swing.JButton jButtonZonaGamer;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JPanel panelInicio;
    // End of variables declaration//GEN-END:variables
}
