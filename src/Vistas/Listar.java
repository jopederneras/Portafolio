/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;
import java.sql.*;
import BD.Conexion;
import javax.swing.JOptionPane;


import javax.swing.table.DefaultTableModel;


public class Listar extends javax.swing.JFrame {
   PreparedStatement ps;
    ResultSet rs;

   
    public Listar() {
        initComponents();

        
        try{
            DefaultTableModel modelo = new DefaultTableModel();
            TablaDeDatos.setModel(modelo);
            
            Connection cn;
            Conexion con=new Conexion();
            cn = con.conectar();
        
            String sql = "SELECT id, producto, tipo, nombre, precio, cantidad, fecha_compra, fecha_caducidad FROM producto";  
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            
            modelo.addColumn("ID");
            modelo.addColumn("PRODUCTO");
            modelo.addColumn("TIPO");
            modelo.addColumn("NOMBRE");
            modelo.addColumn("PRECIO");
            modelo.addColumn("CANTIDAD");
            modelo.addColumn("FECHA_COMPRA");
            modelo.addColumn("FECHA_CADUCIDAD");
            
            
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

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar2 = new javax.swing.JScrollBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnVolverLista = new javax.swing.JButton();
        btnFiltrar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        cboxProducto2 = new javax.swing.JComboBox<>();
        cboxTipo2 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDeDatos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 51, 51));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Lista de productos:");

        btnVolverLista.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnVolverLista.setText("Volver");
        btnVolverLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverListaActionPerformed(evt);
            }
        });

        btnFiltrar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        cboxProducto2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Carne", "Verdura", "No perecible", "Marisco", "Bebidas", "Aderezo", "Especias", "Frutas" }));
        cboxProducto2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxProducto2ActionPerformed(evt);
            }
        });

        cboxTipo2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pollo", "Vacuno", "Cerdo", "Pescado", "Molusco", "Crustacio", "Arroz", "Pasta", "Bebida alcoholica", "Bebida gaseosa", "Bebida sin gas", "Bebidas calientes", "Salsas", "Liquidos?", "Aliños", "Tomate", "lechuga", "Apio", "Pepino", "Ajo", "Pimenton", "Espinaca", " " }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 10, Short.MAX_VALUE)
                        .addComponent(btnVolverLista, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnFiltrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cboxTipo2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxProducto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addGap(55, 55, 55)
                .addComponent(btnFiltrar)
                .addGap(18, 18, 18)
                .addComponent(cboxProducto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cboxTipo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEliminar)
                .addGap(59, 59, 59)
                .addComponent(btnVolverLista)
                .addGap(23, 23, 23))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        TablaDeDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Producto", "Tipo", "Nombre", "Cantidad", "Precio", "Fecha Compra", "Fecha Caducidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaDeDatos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 857, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverListaActionPerformed
         dispose();
            
    }//GEN-LAST:event_btnVolverListaActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        String producto = cboxProducto2.getSelectedItem().toString();
        String tipo = cboxTipo2.getSelectedItem().toString();
        String where = "";
        
        if(!"".equals(producto))
        {
            where = " WHERE producto = '" + producto +  "'";
            
            if(!"".equals(tipo)){
                where = " WHERE tipo = '" + tipo +  "'";
                
                
               
               
            }
            
      
        } 
        
        
        
        
        
        
        try{
            DefaultTableModel modelo = new DefaultTableModel();
            TablaDeDatos.setModel(modelo);
            
            Connection cn;
            Conexion con=new Conexion();
            cn = con.conectar();
        
            String sql = "SELECT id, producto, tipo, nombre, precio, cantidad, fecha_compra, fecha_caducidad FROM producto" + where; 
            System.out.println(sql);
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            
            modelo.addColumn("ID");
            modelo.addColumn("PRODUCTO");
            modelo.addColumn("TIPO");
            modelo.addColumn("NOMBRE");
            modelo.addColumn("PRECIO");
            modelo.addColumn("CANTIDAD");
            modelo.addColumn("FECHA_COMPRA");
            modelo.addColumn("FECHA_CADUCIDAD");
            
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
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void cboxProducto2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxProducto2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxProducto2ActionPerformed

    
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
            java.util.logging.Logger.getLogger(Listar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Listar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Listar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Listar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Listar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaDeDatos;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnVolverLista;
    private javax.swing.JComboBox<String> cboxProducto2;
    private javax.swing.JComboBox<String> cboxTipo2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollBar jScrollBar2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
