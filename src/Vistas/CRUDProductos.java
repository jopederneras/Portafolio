/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Modelo.Conexion;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.awt.event.ItemEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;


public class CRUDProductos extends javax.swing.JFrame { 
  
    public CRUDProductos() {
        initComponents();
        
        try{
            DefaultTableModel modelo = new DefaultTableModel();
            PreparedStatement ps = null;
            ResultSet rs = null;
            TablaDeDatos.setModel(modelo);
            
            Connection cn;
            Conexion con=new Conexion();
            cn = con.getConexion();
        
            String sql = "SELECT id, producto, tipo, nombre, precio, cantidad, fecha_compra FROM productos";  
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            
            modelo.addColumn("ID");
            modelo.addColumn("PRODUCTO");
            modelo.addColumn("TIPO");
            modelo.addColumn("NOMBRE");
            modelo.addColumn("PRECIO");
            modelo.addColumn("CANTIDAD");
            modelo.addColumn("FECHA_COMPRA");
            
            
            while(rs.next()){
                
                Object[] filas = new Object[cantidadColumnas];
                
                for(int i = 0; i< cantidadColumnas; i++ )
                {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            
            
            }
            
        }catch(SQLException ex){
            System.err.println(ex.toString());
            
        }
        
    }
    
    
    public String [] getTipo (String productos) //Para que los Combobox solo muestren la info del producto correspondiente.
    {
    String [] tipo = new String[4];
    if(productos.equalsIgnoreCase("Carne"))
    {
        
        tipo[0] = "Vacuno";
        tipo[1] = "Cerdo";
        tipo[2] = "Pollo";
        tipo[3] = "Pescado";
    }
    
    if(productos.equalsIgnoreCase("Verdura"))
    {
        
        tipo[0] = "Tomate";
        tipo[1] = "Lechuga";
        tipo[2] = "Pimiento";
        tipo[3] = "Acelga";
    }
    if(productos.equalsIgnoreCase("No perecible"))
    {
        
        tipo[0] = "Pasta";
        tipo[1] = "Arroz";
        tipo[2] = "Legumbres";
        tipo[3] = "Otros";
    }
    if(productos.equalsIgnoreCase("Marisco"))
    {
        
        tipo[0] = "Crustacio";
        tipo[1] = "Molusco";
        tipo[2] = "Otros";
        
    }
    if(productos.equalsIgnoreCase("Bebidas"))
    {
        
        tipo[0] = "Calientes";
        tipo[1] = "Gaseosa";
        tipo[2] = "Sin gas";
        tipo[3] = "Alcoholica";
    }
    if(productos.equalsIgnoreCase("Aderezo"))
    {
        
        tipo[0] = "Salsa";
        tipo[1] = "liquidos";
        tipo[2] = "Otros";
        
    }
    if(productos.equalsIgnoreCase("Especias"))
    {
        
        tipo[0] = "Aliño";
        tipo[1] = "semillas";
        tipo[2] = "Otros";
        
    }
    if(productos.equalsIgnoreCase("Frutas"))
    {
        
        tipo[0] = "Manzana";
        tipo[1] = "naranja";
        tipo[2] = "melon";
        tipo[3] = "Sandia";
    }
    return tipo;
    }
    
    

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jbAgregarProducto = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        lblAgregar = new javax.swing.JLabel();
        jbModificar = new javax.swing.JButton();
        jbRecargar = new javax.swing.JButton();
        jbFiltrar = new javax.swing.JButton();
        cboxFiltrarProducto = new javax.swing.JComboBox<>();
        cboxFiltrarTipo = new javax.swing.JComboBox<>();
        jbEliminar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        cboxProducto = new javax.swing.JComboBox<>();
        txtCantidad = new javax.swing.JTextField();
        cboxTipo = new javax.swing.JComboBox<>();
        txtCompra = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDeDatos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 51, 51));

        jbAgregarProducto.setText("Agregar");
        jbAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarProductoActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        lblAgregar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblAgregar.setForeground(new java.awt.Color(255, 255, 255));
        lblAgregar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAgregar.setText("Mantenedor de Productos");

        jbModificar.setText("Modificar");

        jbRecargar.setText("Recargar datos");
        jbRecargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRecargarActionPerformed(evt);
            }
        });

        jbFiltrar.setText("Filtrar");

        cboxFiltrarProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Carne", "Verdura", "No perecible", "Marisco", "Bebidas", "Aderezo", "Especias", "Frutas" }));

        cboxFiltrarTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cboxFiltrarProducto, 0, 85, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboxFiltrarTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbAgregarProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbRecargar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbFiltrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jbAgregarProducto)
                .addGap(18, 18, 18)
                .addComponent(jbModificar)
                .addGap(18, 18, 18)
                .addComponent(jbRecargar)
                .addGap(18, 18, 18)
                .addComponent(jbFiltrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxFiltrarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxFiltrarTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addComponent(jbSalir)
                .addGap(27, 27, 27))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText(" Producto:");

        jLabel3.setText("Tipo:");

        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        cboxProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Carne", "Verdura", "No perecible", "Marisco", "Bebidas", "Aderezo", "Especias", "Frutas" }));
        cboxProducto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboxProductoItemStateChanged(evt);
            }
        });
        cboxProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxProductoActionPerformed(evt);
            }
        });

        cboxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", " ", " " }));
        cboxTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxTipoActionPerformed(evt);
            }
        });

        jLabel5.setText("Precio:");

        jLabel6.setText("Nombre:");

        jLabel7.setText("Cantidad:");

        jLabel8.setText("Fecha compra:");

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        TablaDeDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Producto", "Tipo", "Nombre", "Precio", "Cantidad", "Fecha de compra"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TablaDeDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaDeDatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaDeDatos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboxProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                            .addComponent(txtId))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(txtCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 717, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txtCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cboxProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cboxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void cboxProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxProductoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void jbAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarProductoActionPerformed
      
    }//GEN-LAST:event_jbAgregarProductoActionPerformed

    private void cboxTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxTipoActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void jbRecargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRecargarActionPerformed
        try{
            DefaultTableModel modelo = new DefaultTableModel();
            PreparedStatement ps = null;
            ResultSet rs = null;
            TablaDeDatos.setModel(modelo);
            
            Connection cn;
            Conexion con=new Conexion();
            cn = con.getConexion();
        
            String sql = "SELECT id, producto, tipo, nombre, precio, cantidad, fecha_compra FROM productos";  
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            
            modelo.addColumn("ID");
            modelo.addColumn("PRODUCTO");
            modelo.addColumn("TIPO");
            modelo.addColumn("NOMBRE");
            modelo.addColumn("PRECIO");
            modelo.addColumn("CANTIDAD");
            modelo.addColumn("FECHA_COMPRA");
            
            
            while(rs.next()){
                
                Object[] filas = new Object[cantidadColumnas];
                
                for(int i = 0; i< cantidadColumnas; i++ )
                {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            
            
            }
            
        }catch(SQLException ex){
            System.err.println(ex.toString());
            
        }
    }//GEN-LAST:event_jbRecargarActionPerformed

    private void cboxProductoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboxProductoItemStateChanged
        if(evt.getStateChange()== ItemEvent.SELECTED)
       {
           if(this.cboxProducto.getSelectedIndex()>0)
           {
               this.cboxTipo.setModel(new DefaultComboBoxModel(this.getTipo(this.cboxProducto.getSelectedItem().toString())));
           }
       }
    }//GEN-LAST:event_cboxProductoItemStateChanged

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void TablaDeDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaDeDatosMouseClicked
        
        if(evt.getClickCount() ==2)
        {
            JTable receptor = (JTable)evt.getSource();
            
            txtId.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(),0).toString());
            cboxProducto.setSelectedItem(receptor.getModel().getValueAt(receptor.getSelectedRow(),1).toString());
            cboxTipo.setSelectedItem(receptor.getModel().getValueAt(receptor.getSelectedRow(),2).toString());
            txtNombre.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(),3).toString());
            txtPrecio.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(),4).toString());
            txtCantidad.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(),5).toString());
            txtCompra.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(),6).toString());
        }
    }//GEN-LAST:event_TablaDeDatosMouseClicked

 
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CRUDProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable TablaDeDatos;
    public javax.swing.JComboBox<String> cboxFiltrarProducto;
    public javax.swing.JComboBox<String> cboxFiltrarTipo;
    public javax.swing.JComboBox<String> cboxProducto;
    public javax.swing.JComboBox<String> cboxTipo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JButton jbAgregarProducto;
    public javax.swing.JButton jbEliminar;
    public javax.swing.JButton jbFiltrar;
    public javax.swing.JButton jbModificar;
    public javax.swing.JButton jbRecargar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JLabel lblAgregar;
    public javax.swing.JTextField txtCantidad;
    public javax.swing.JTextField txtCompra;
    public javax.swing.JTextField txtId;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
