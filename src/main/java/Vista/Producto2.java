/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;



/**
 *
 * @author USER
 */
public class Producto2 extends javax.swing.JPanel {
    
    public Producto2() {
        
        initComponents();
        initStyles();
        textEncabezado();
        imagenProduct1();
        textPrice();
        textDiscount();
        textOriginalPrice();
        textDescription();
        
    }
    
    private void initStyles(){
        //labelNameProduct1.putClientProperty("FlatLaf.style", "font: 200% $light.font");
        //labelNameProduct1.setForeground(Color.white);
    }
    private void textEncabezado(){
        labelNameProduct1.setText("Mouse Inalámbrico Xtech Galos RF 1600 DPI Negro Azul ");//redescribe el nombre para el producto
        labelNameProduct1.setFont(new java.awt.Font("ArialBlack", java.awt.Font.BOLD, 36));//cambia a fuente ArialBlack tamaño 48
        labelNameProduct1.setForeground(Color.white); 
    }
    
    private void imagenProduct1(){
        ImagenProduct1.setText("");
        ImagenProduct1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MouseInalámbricoXtechGalosRF 1600DPINegroAzul 500x500.jpg")));
    }
    
    private void textPrice(){
        labelPrice.setText("S/."+"20");//redescribe el nombre para el producto
        labelPrice.setFont(new java.awt.Font("ArialBlack", java.awt.Font.BOLD, 24));//cambia a fuente ArialBlack tamaño 48
        labelPrice.setForeground(java.awt.Color.BLACK); 
    }
    
    private void textDiscount(){
        labelDiscount.setText("-"+"35"+"%");//redescribe el nombre para el producto
        labelDiscount.setFont(new java.awt.Font("ArialBlack", java.awt.Font.BOLD, 24));//cambia a fuente ArialBlack tamaño 48
        labelDiscount.setForeground(java.awt.Color.RED); 
    }
    
    private void textOriginalPrice(){
        labelOriginalPrice.setText("<html><strike>S/."+"27"+"</strike></html>");//redescribe el nombre para el producto
        labelOriginalPrice.setFont(new java.awt.Font("ArialBlack", java.awt.Font.BOLD, 24));//cambia a fuente ArialBlack tamaño 48
        labelOriginalPrice.setForeground(Color.gray); 
    }
    
    private void textDescription(){
        descriptionProduct.setText("El Mouse Inalámbrico Xtech Galos es un dispositivo de alta precisión con una resolución\n"
                + "de hasta 1600 DPI, ideal para trabajos que requieren agilidad y precisión en el movimiento.\n"
                + "Funciona mediante conexión RF (Radiofrecuencia) para una experiencia inalámbrica fluida,\n"
                + "eliminando la necesidad de cables. Su diseño en color negro y azul lo hace atractivo y\n"
                + "moderno, mientras que su forma ergonómica garantiza comodidad durante largas horas de uso.");//redescribe el nombre para el producto
        descriptionProduct.setEditable(false);
        descriptionProduct.setFont(new java.awt.Font("ArialBlack", java.awt.Font.PLAIN, 16));//cambia a fuente ArialBlack tamaño 48
        descriptionProduct.setForeground(java.awt.Color.BLACK); 
    }
    
    
    

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
        labelDiscount = new javax.swing.JLabel();
        labelOriginalPrice = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionProduct = new javax.swing.JTextArea();
        SpinnerP1 = new javax.swing.JSpinner();
        LabelCantidad = new javax.swing.JLabel();
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

        labelDiscount.setText("discount%");

        labelOriginalPrice.setText("originalPrice$");

        jScrollPane1.setBackground(new java.awt.Color(0, 204, 204));
        jScrollPane1.setBorder(null);

        descriptionProduct.setBackground(new java.awt.Color(0, 204, 204));
        descriptionProduct.setColumns(20);
        descriptionProduct.setForeground(new java.awt.Color(0, 204, 204));
        descriptionProduct.setRows(5);
        descriptionProduct.setBorder(null);
        descriptionProduct.setDisabledTextColor(new java.awt.Color(0, 204, 204));
        jScrollPane1.setViewportView(descriptionProduct);

        SpinnerP1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        SpinnerP1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204)));

        LabelCantidad.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        LabelCantidad.setText("Cantidad");

        LabelImagenRelleno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gato80x80.jpg"))); // NOI18N

        javax.swing.GroupLayout PanelFondoDescripcionLayout = new javax.swing.GroupLayout(PanelFondoDescripcion);
        PanelFondoDescripcion.setLayout(PanelFondoDescripcionLayout);
        PanelFondoDescripcionLayout.setHorizontalGroup(
            PanelFondoDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFondoDescripcionLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(labelPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelDiscount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(539, 539, 539))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(PanelFondoDescripcionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelOriginalPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFondoDescripcionLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(LabelCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SpinnerP1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(159, 159, 159))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFondoDescripcionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelImagenRelleno)
                .addGap(270, 270, 270))
        );
        PanelFondoDescripcionLayout.setVerticalGroup(
            PanelFondoDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFondoDescripcionLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(PanelFondoDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelDiscount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelOriginalPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanelFondoDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LabelCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SpinnerP1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelImagenRelleno)
                .addGap(79, 79, 79))
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
    private javax.swing.JSpinner SpinnerP1;
    private javax.swing.JTextArea descriptionProduct;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelDiscount;
    private javax.swing.JLabel labelNameProduct1;
    private javax.swing.JLabel labelOriginalPrice;
    private javax.swing.JLabel labelPrice;
    // End of variables declaration//GEN-END:variables
}
