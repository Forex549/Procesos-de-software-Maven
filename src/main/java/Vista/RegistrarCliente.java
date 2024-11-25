
package Vista;
import Conexión.Conexión;
import Modelo.ConexionLogin;
import java.awt.CardLayout;
import java.awt.Color;
import java.sql.Connection;
import Controlador.*;
/**
 *
 * @author MATHIAS
 */
public class RegistrarCliente extends javax.swing.JPanel {

    //private Principal principal;
    CardLayout cardLayout; //se tuvieron q colocar estos dos como atributo para poder pasarlos ccomo
    //parametro en el constructor ya que no hay controlador para hcerlo desde el main :D .L.
    Principal principal;
    Tienda tienda;
    JpanelCarrito carrito;
    Connection con;
    public int ID;

    

    /**
     * Creates new form Login
     */
    public RegistrarCliente() {
       
        //this.principal = principal;
        initComponents();
        initStyles();
        addRoundedPanel();
    }
    
    private void initStyles(){
        jTextFieldCorreo.putClientProperty( "JComponent.roundRect", true );
        jTextFieldPassword.putClientProperty( "JComponent.roundRect", true );
        jTextFieldNombres.putClientProperty( "JComponent.roundRect", true );
        jTextFieldApellidos.putClientProperty( "JComponent.roundRect", true );
        jTextFieldTelefono.putClientProperty( "JComponent.roundRect", true );
        jTextFieldDireccion.putClientProperty( "JComponent.roundRect", true );
        jTextFieldCorreo.setColumns(15); // 15 columnas visibles
        jTextFieldPassword.setColumns(15);
        jTextFieldNombres.setColumns(15);
        jTextFieldApellidos.setColumns(15);
        jTextFieldTelefono.setColumns(15);
        jTextFieldDireccion.setColumns(15);
        btnRegistrar.putClientProperty( "JButton.buttonType", "roundRect" );
    }
    
    private void addRoundedPanel() {    
        RoundedPanel roundedPanel = new RoundedPanel(30); // Bordes redondeados con radio de 30
        roundedPanel.setBackground(Color.LIGHT_GRAY); // Fondo gris para el RoundedPanel
        roundedPanel.setPreferredSize(new java.awt.Dimension(760, 520)); // Tamaño preferido

        java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
        roundedPanel.setLayout(layout);

        // Posiciona el jLabel1 (imagen) en el centro superior
        gbc.gridx = 0; 
        gbc.gridy = 0;
        gbc.gridwidth = 4; // Ocupa dos columnas para centrar
        gbc.anchor = java.awt.GridBagConstraints.CENTER;
        gbc.insets = new java.awt.Insets(10, 0, 20, 0); // Espacio alrededor de la imagen
        roundedPanel.add(jLabel1, gbc);

        // Agrega la etiqueta de usuario en la siguiente fila
        gbc.gridwidth = 1; // Restablece a una columna
        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.anchor = java.awt.GridBagConstraints.EAST;
        gbc.insets = new java.awt.Insets(10, 10, 10, 5); // Ajuste de espacio para alineación
        roundedPanel.add(jLabelNombres, gbc);

        // Campo de texto de usuario al lado de la etiqueta
        gbc.gridx = 1;
        gbc.anchor = java.awt.GridBagConstraints.WEST;
        gbc.insets = new java.awt.Insets(10, 5, 10, 10);
        roundedPanel.add(jTextFieldNombres, gbc);
        
        // Agrega la etiqueta de usuario en la siguiente fila
        gbc.gridwidth = 1; // Restablece a una columna
        gbc.gridy = 1;
        gbc.gridx = 2;
        gbc.anchor = java.awt.GridBagConstraints.EAST;
        gbc.insets = new java.awt.Insets(10, 10, 10, 5); // Ajuste de espacio para alineación
        roundedPanel.add(jLabelApellidos, gbc);

        // Campo de texto de usuario al lado de la etiqueta
        gbc.gridx = 3;
        gbc.anchor = java.awt.GridBagConstraints.WEST;
        gbc.insets = new java.awt.Insets(10, 5, 10, 10);
        roundedPanel.add(jTextFieldApellidos, gbc);
        
        // Agrega la etiqueta de usuario en la siguiente fila
        gbc.gridwidth = 1; // Restablece a una columna
        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.anchor = java.awt.GridBagConstraints.EAST;
        gbc.insets = new java.awt.Insets(10, 10, 10, 5); // Ajuste de espacio para alineación
        roundedPanel.add(jLabelCorreo, gbc);

        // Campo de texto de usuario al lado de la etiqueta
        gbc.gridx = 1;
        gbc.anchor = java.awt.GridBagConstraints.WEST;
        gbc.insets = new java.awt.Insets(10, 5, 10, 10);
        roundedPanel.add(jTextFieldCorreo, gbc);
        
        // Agrega la etiqueta de usuario en la siguiente fila
        gbc.gridwidth = 1; // Restablece a una columna
        gbc.gridy = 2;
        gbc.gridx = 2;
        gbc.anchor = java.awt.GridBagConstraints.EAST;
        gbc.insets = new java.awt.Insets(10, 10, 10, 5); // Ajuste de espacio para alineación
        roundedPanel.add(jLabelTelefono, gbc);

        // Campo de texto de usuario al lado de la etiqueta
        gbc.gridx = 3;
        gbc.anchor = java.awt.GridBagConstraints.WEST;
        gbc.insets = new java.awt.Insets(10, 5, 10, 10);
        roundedPanel.add(jTextFieldTelefono, gbc);
        
        // Agrega la etiqueta de usuario en la siguiente fila
        gbc.gridwidth = 1; // Restablece a una columna
        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.anchor = java.awt.GridBagConstraints.EAST;
        gbc.insets = new java.awt.Insets(10, 10, 10, 5); // Ajuste de espacio para alineación
        roundedPanel.add(jLabelDireccion, gbc);

        // Campo de texto de usuario al lado de la etiqueta
        gbc.gridx = 1;
        gbc.anchor = java.awt.GridBagConstraints.WEST;
        gbc.insets = new java.awt.Insets(10, 5, 10, 10);
        roundedPanel.add(jTextFieldDireccion, gbc);

        // Etiqueta de contraseña en la siguiente fila
        gbc.gridy = 3;
        gbc.gridx = 2;
        gbc.anchor = java.awt.GridBagConstraints.EAST;
        roundedPanel.add(jLabelPassword, gbc);

        // Campo de texto de contraseña al lado de la etiqueta
        gbc.gridx = 3;
        gbc.anchor = java.awt.GridBagConstraints.WEST;
        roundedPanel.add(jTextFieldPassword, gbc);

        // Botón de ingreso en la penúltima fila, centrado
        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 4; // Ocupa ambas columnas para centrarse
        gbc.anchor = java.awt.GridBagConstraints.CENTER;
        gbc.insets = new java.awt.Insets(20, 0, 10, 0);
        btnRegistrar.setPreferredSize(new java.awt.Dimension(120, 40));
        roundedPanel.add(btnRegistrar, gbc);

        // Ajuste del layout de jPanel1 para centrar el RoundedPanel
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(roundedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(roundedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        // Revalidar y repintar para actualizar la interfaz
        jPanel1.revalidate();
        jPanel1.repaint();
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
        btnRegistrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabelCorreo = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        jTextFieldPassword = new javax.swing.JPasswordField();
        jTextFieldCorreo = new javax.swing.JTextField();
        jLabelNombres = new javax.swing.JLabel();
        jLabelApellidos = new javax.swing.JLabel();
        jTextFieldNombres = new javax.swing.JTextField();
        jTextFieldApellidos = new javax.swing.JTextField();
        jLabelTelefono = new javax.swing.JLabel();
        jTextFieldTelefono = new javax.swing.JTextField();
        jLabelDireccion = new javax.swing.JLabel();
        jTextFieldDireccion = new javax.swing.JTextField();

        setBackground(new java.awt.Color(51, 51, 255));
        setPreferredSize(new java.awt.Dimension(1200, 640));

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));

        btnRegistrar.setBackground(new java.awt.Color(51, 51, 255));
        btnRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(51, 255, 255));
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(153, 255, 255));
        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 153));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/file.jpg"))); // NOI18N
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabelCorreo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelCorreo.setForeground(new java.awt.Color(255, 255, 0));
        jLabelCorreo.setText("CORREO");

        jLabelPassword.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelPassword.setForeground(new java.awt.Color(255, 255, 0));
        jLabelPassword.setText("PASSWORD");

        jTextFieldPassword.setBackground(new java.awt.Color(255, 255, 255));

        jTextFieldCorreo.setBackground(new java.awt.Color(255, 255, 255));

        jLabelNombres.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelNombres.setForeground(new java.awt.Color(255, 255, 0));
        jLabelNombres.setText("NOMBRES");

        jLabelApellidos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelApellidos.setForeground(new java.awt.Color(255, 255, 0));
        jLabelApellidos.setText("APELLIDOS");

        jTextFieldNombres.setBackground(new java.awt.Color(255, 255, 255));

        jTextFieldApellidos.setBackground(new java.awt.Color(255, 255, 255));

        jLabelTelefono.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelTelefono.setForeground(new java.awt.Color(255, 255, 0));
        jLabelTelefono.setText("TELÉFONO");

        jTextFieldTelefono.setBackground(new java.awt.Color(255, 255, 255));

        jLabelDireccion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelDireccion.setForeground(new java.awt.Color(255, 255, 0));
        jLabelDireccion.setText("DIRECCION");

        jTextFieldDireccion.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(97, 97, 97))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabelCorreo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabelNombres)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabelDireccion)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabelTelefono)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap()))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelApellidos)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelPassword)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCorreo)
                            .addComponent(jTextFieldCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNombres)
                            .addComponent(jTextFieldNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelApellidos))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelTelefono))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDireccion))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPassword))
                        .addGap(31, 31, 31)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)))
                .addGap(104, 104, 104))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(295, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(275, 275, 275))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        

    }//GEN-LAST:event_btnRegistrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelApellidos;
    private javax.swing.JLabel jLabelCorreo;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelNombres;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField jTextFieldApellidos;
    public javax.swing.JTextField jTextFieldCorreo;
    public javax.swing.JTextField jTextFieldDireccion;
    public javax.swing.JTextField jTextFieldNombres;
    public javax.swing.JPasswordField jTextFieldPassword;
    public javax.swing.JTextField jTextFieldTelefono;
    // End of variables declaration//GEN-END:variables
}
