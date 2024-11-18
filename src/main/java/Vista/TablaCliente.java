
package Vista;

import java.awt.Color;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;

/**
 *
 * @author MATHIAS
 */
public class TablaCliente extends javax.swing.JPanel {

    /**
     * Creates new form TablaCliente
     */
    public TablaCliente() {
        // Configuración del tema
        FlatMaterialLighterIJTheme.setup();
        initComponents();
        initStyles();
    }
    
    public void initStyles(){
        // Bordes redondeados y color de fondo claro para los campos de texto
    txtFiltro.putClientProperty("JComponent.roundRect", true);
    txtFiltro.putClientProperty("JComponent.outline", new Color(55, 71, 79)); // Color de borde oscuro
    txtFiltro.setBackground(Color.GRAY);
    
    btnVer.setBackground(new Color(2, 136, 209));
    btnVer.setForeground(Color.WHITE);
    
    btnBuscar.setBackground(new Color(2, 136, 209));
    btnBuscar.setForeground(Color.WHITE);
    
    // Establece borde oscuro en la tabla
    table.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(55, 71, 79), 2));
    scroll.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(55, 71, 79), 2));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelFiltro = new javax.swing.JLabel();
        txtFiltro = new javax.swing.JTextField();
        scroll = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnVer = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 204, 204));
        setPreferredSize(new java.awt.Dimension(1280, 620));

        jLabelFiltro.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelFiltro.setForeground(new java.awt.Color(255, 255, 0));
        jLabelFiltro.setText("FILTRAR:");

        txtFiltro.setBackground(new java.awt.Color(204, 204, 204));

        scroll.setBackground(new java.awt.Color(1, 138, 190));
        scroll.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        table.setBackground(new java.awt.Color(222, 232, 241));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRE", "PRECIO", "STOCK", "MARCA", "CATEGORÍA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Float.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table.setGridColor(new java.awt.Color(1, 138, 190));
        table.setSelectionBackground(new java.awt.Color(1, 138, 190));
        table.getTableHeader().setReorderingAllowed(false);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        scroll.setViewportView(table);

        btnVer.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnVer.setText("VER");
        btnVer.setPreferredSize(new java.awt.Dimension(76, 32));

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBuscar.setText("BUSCAR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabelFiltro)
                .addGap(18, 18, 18)
                .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(195, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnVer, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 881, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(204, 204, 204))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFiltro)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        //int row = table.getSelectedRow();
        //int column = table.getSelectedColumn();

        //String id = table.getValueAt(row, 0).toString();
        //jTextFieldId.setText(id);

        //String value = table.getValueAt(row, column).toString();
        //jTextFieldNota.setText(value);
        //esto no lo uses
    }//GEN-LAST:event_tableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnVer;
    private javax.swing.JLabel jLabelFiltro;
    private javax.swing.JScrollPane scroll;
    public javax.swing.JTable table;
    public javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables
}
