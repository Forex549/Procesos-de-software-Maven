package Vista;

import Modelo.Product;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;



/**
 *
 * @author USER
 */
public class VistaInfo extends javax.swing.JPanel {
    
    public VistaInfo() {
        
        initComponents();
        //initStyles();
        //textEncabezado();
        //imagenProduct1();
        //textPrice();
        //textDescription();
        
    }
    
    /*private void initStyles(){
        labelNameProduct1.putClientProperty("FlatLaf.style", "font: 200% $light.font");
        labelNameProduct1.setForeground(Color.white);
    }*/
    /*private void textEncabezado(){
        labelNameProduct1.setText("Teclado Mecanico Gamer Antryx THL MK830, switch Azul, RGB");//redescribe el nombre para el producto
        labelNameProduct1.setFont(new java.awt.Font("ArialBlack", java.awt.Font.BOLD, 36));//cambia a fuente ArialBlack tamaño 48
        labelNameProduct1.setForeground(Color.white); 
    }*/
    
    /*private void imagenProduct1(){
        ImagenProduct1.setText("");
        ImagenProduct1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TecladoMecanicoTKLntryxChromeStormMK830BlueSwitch 500x500.jpg")));
    }*/
    
    /*private void textPrice(){
        labelPrice.setText("S/."+"212.36");//redescribe el nombre para el producto
        labelPrice.setFont(new java.awt.Font("ArialBlack", java.awt.Font.BOLD, 24));//cambia a fuente ArialBlack tamaño 48
        labelPrice.setForeground(java.awt.Color.BLACK); 
    }*/
    
    
    
    
    /*private void textDescription(){
        descriptionProduct.setText("Características Factor de forma TKL, tamaño compacto que conserva la funcionalidad 13 efectos\n"
                + "de iluminación preestablecidos, el usuario puede ajustar el brillo de la luz de fondo, la velocidad\n"
                + "de respiración, la dirección de la luz de fondo y otros efectos de iluminación 5 zonas de iluminación\n"
                + "de género de juego configurables, asigna qué teclas quieres iluminar, ideal para: (MOBA, FPS, CF,\n"
                + "COD, RTS, LOL, Racing, NBA) Todas las teclas con tecnología antighosting, cada pulsación de tecla\n"
                + "se detecta correctamente Teclas de Doble Inyección Plástica. Las teclas moldeadas por inyección\n"
                + "de doble disparo ofrecen una retroiluminación uniforme y nítida y una letra que no se raya Macros\n"
                + "y perfiles de software personalizables Tapa superior de aluminio, mejor estética y más resistente\n"
                + "12 funciones multimedia y de oficina VIDA ÚTIL DE LAS LLAVES: 50000000 (50 millones) LLAVES:\n"
                + "88 – INTERFAZ: USB LONGITUD DEL CABLE: 1.8M – PESO: 1140GR – TAMAÑO: 353 x 119 x 32MM\n"
                + "Compatible con Windows 98 / NT / ME / 2000 / XP / VISTA / 7/8/10");//redescribe el nombre para el producto
        descriptionProduct.setEditable(false);
        descriptionProduct.setFont(new java.awt.Font("ArialBlack", java.awt.Font.PLAIN, 14));//cambia a fuente ArialBlack tamaño 48
        descriptionProduct.setForeground(java.awt.Color.BLACK); 
    }*/
    
    /*public void mostrarProducto(Product product) {
    labelNameProduct1.setText(product.getNombre());
    labelPrice.setText("S/." + String.format("%.2f", product.getPrecio()));
    descriptionProduct.setText(product.getDescripcion());
    ImagenProduct1.setIcon(new javax.swing.ImageIcon(getClass().getResource(product.getImagenPath())));
}*/
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelMadre = new javax.swing.JPanel();
        PanelFondoNombreProducto = new javax.swing.JPanel();
        labelNameProduct1 = new javax.swing.JLabel();
        ImagenProduct1 = new javax.swing.JLabel();
        PanelFondoDescripcion = new javax.swing.JPanel();
        labelPrice = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionProduct = new javax.swing.JTextArea();
        comboCantidad = new javax.swing.JSpinner();
        LabelCantidad = new javax.swing.JLabel();
        btnAgregarCarr = new javax.swing.JToggleButton();
        LabelImagenRelleno = new javax.swing.JLabel();

        PanelMadre.setBackground(new java.awt.Color(0, 204, 204));

        PanelFondoNombreProducto.setBackground(new java.awt.Color(0, 0, 0));

        labelNameProduct1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        labelNameProduct1.setForeground(new java.awt.Color(255, 255, 255));
        labelNameProduct1.setText("nameProduct1");

        javax.swing.GroupLayout PanelFondoNombreProductoLayout = new javax.swing.GroupLayout(PanelFondoNombreProducto);
        PanelFondoNombreProducto.setLayout(PanelFondoNombreProductoLayout);
        PanelFondoNombreProductoLayout.setHorizontalGroup(
            PanelFondoNombreProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFondoNombreProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelNameProduct1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelFondoNombreProductoLayout.setVerticalGroup(
            PanelFondoNombreProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFondoNombreProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelNameProduct1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ImagenProduct1.setText("jLabel1");

        PanelFondoDescripcion.setBackground(new java.awt.Color(0,0,0,0));

        labelPrice.setText("Price$");

        jScrollPane1.setBackground(new java.awt.Color(0, 204, 204));
        jScrollPane1.setBorder(null);

        descriptionProduct.setBackground(new java.awt.Color(0, 204, 204));
        descriptionProduct.setColumns(20);
        descriptionProduct.setForeground(new java.awt.Color(0, 204, 204));
        descriptionProduct.setRows(5);
        descriptionProduct.setBorder(null);
        descriptionProduct.setDisabledTextColor(new java.awt.Color(0, 204, 204));
        jScrollPane1.setViewportView(descriptionProduct);

        comboCantidad.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        comboCantidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204)));

        LabelCantidad.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        LabelCantidad.setText("Cantidad");

        btnAgregarCarr.setBackground(new java.awt.Color(0, 0, 0));
        btnAgregarCarr.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        btnAgregarCarr.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarCarr.setText("AGREGAR AL CARRO");
        btnAgregarCarr.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        LabelImagenRelleno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gato80x80.jpg"))); // NOI18N

        javax.swing.GroupLayout PanelFondoDescripcionLayout = new javax.swing.GroupLayout(PanelFondoDescripcion);
        PanelFondoDescripcion.setLayout(PanelFondoDescripcionLayout);
        PanelFondoDescripcionLayout.setHorizontalGroup(
            PanelFondoDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFondoDescripcionLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(labelPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(605, 605, 605))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFondoDescripcionLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(LabelCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(159, 159, 159))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFondoDescripcionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelFondoDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFondoDescripcionLayout.createSequentialGroup()
                        .addComponent(btnAgregarCarr, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFondoDescripcionLayout.createSequentialGroup()
                        .addComponent(LabelImagenRelleno)
                        .addGap(270, 270, 270))))
        );
        PanelFondoDescripcionLayout.setVerticalGroup(
            PanelFondoDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFondoDescripcionLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(labelPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanelFondoDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LabelCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboCantidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelImagenRelleno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAgregarCarr, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout PanelMadreLayout = new javax.swing.GroupLayout(PanelMadre);
        PanelMadre.setLayout(PanelMadreLayout);
        PanelMadreLayout.setHorizontalGroup(
            PanelMadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelFondoNombreProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelMadreLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(ImagenProduct1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(PanelFondoDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PanelMadreLayout.setVerticalGroup(
            PanelMadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMadreLayout.createSequentialGroup()
                .addComponent(PanelFondoNombreProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(27, 27, 27)
                .addGroup(PanelMadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ImagenProduct1)
                    .addComponent(PanelFondoDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(123, 123, 123))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelMadre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelMadre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ImagenProduct1;
    private javax.swing.JLabel LabelCantidad;
    private javax.swing.JLabel LabelImagenRelleno;
    private javax.swing.JPanel PanelFondoDescripcion;
    private javax.swing.JPanel PanelFondoNombreProducto;
    private javax.swing.JPanel PanelMadre;
    public javax.swing.JToggleButton btnAgregarCarr;
    public javax.swing.JSpinner comboCantidad;
    public javax.swing.JTextArea descriptionProduct;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel labelNameProduct1;
    public javax.swing.JLabel labelPrice;
    // End of variables declaration//GEN-END:variables
}
