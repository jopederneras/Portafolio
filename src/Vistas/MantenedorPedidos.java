/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Controlador.Conexion;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrador
 */
public class MantenedorPedidos extends javax.swing.JFrame {
    /**
     * Creates new form Pedidos
     */
    public MantenedorPedidos() {
        initComponents();
        txtMesa.setVisible(false);
        txtPlatoEntrada.setVisible(false);
        txtPlatoPrincipal.setVisible(false);
        txtBebidas.setVisible(false);
        txtPostre.setVisible(false);
        txtEstado.setVisible(false);
        
         try{
            DefaultTableModel modelo = new DefaultTableModel();
            PreparedStatement ps = null;
            ResultSet rs = null;
            TablaDePedidos.setModel(modelo);
            
            Connection cn;
            Conexion con=new Conexion();
            cn = con.getConexion();
        
            String sql = "SELECT mesa, plato_entrada, plato_principal, bebida, postre, estado FROM pedidos";  
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            
            modelo.addColumn("Mesa");
            modelo.addColumn("Platillos de entrada");
            modelo.addColumn("Platillos Principales");
            modelo.addColumn("Bebidas");
            modelo.addColumn("Postres");
            modelo.addColumn("Estado del pedido");
            
            
            
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDePedidos = new javax.swing.JTable();
        jbEnProceso = new javax.swing.JButton();
        jbCompletado = new javax.swing.JButton();
        jbLimpiarCompletados = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        txtMesa = new javax.swing.JTextField();
        txtPlatoEntrada = new javax.swing.JTextField();
        txtPlatoPrincipal = new javax.swing.JTextField();
        txtBebidas = new javax.swing.JTextField();
        txtPostre = new javax.swing.JTextField();
        txtEstado = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 51, 51));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pedidos del local");

        TablaDePedidos.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        TablaDePedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TablaDePedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaDePedidosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaDePedidos);

        jbEnProceso.setText("En proceso");
        jbEnProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEnProcesoActionPerformed(evt);
            }
        });

        jbCompletado.setText("Completado");
        jbCompletado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCompletadoActionPerformed(evt);
            }
        });

        jbLimpiarCompletados.setText("Limpiar Completados");

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        txtMesa.setEditable(false);
        txtMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMesaActionPerformed(evt);
            }
        });

        txtPlatoEntrada.setEditable(false);
        txtPlatoEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlatoEntradaActionPerformed(evt);
            }
        });

        txtPlatoPrincipal.setEditable(false);

        txtBebidas.setEditable(false);

        txtPostre.setEditable(false);

        txtEstado.setEditable(false);

        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(txtMesa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPlatoEntrada)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPlatoPrincipal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBebidas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPostre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEstado)
                                .addGap(6, 6, 6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbEnProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(jbCompletado, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                .addComponent(jbLimpiarCompletados, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(303, 303, 303)))
                .addGap(42, 42, 42))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbEnProceso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbCompletado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbLimpiarCompletados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMesa)
                    .addComponent(txtPlatoEntrada)
                    .addComponent(txtPlatoPrincipal)
                    .addComponent(txtBebidas)
                    .addComponent(txtPostre)
                    .addComponent(txtEstado))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbEnProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEnProcesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbEnProcesoActionPerformed

    private void jbCompletadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCompletadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbCompletadoActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbSalirActionPerformed

    private void txtMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMesaActionPerformed

    private void txtPlatoEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlatoEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPlatoEntradaActionPerformed

    private void TablaDePedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaDePedidosMouseClicked
        if(evt.getClickCount() ==1)
        {
            JTable receptor = (JTable)evt.getSource();
            
            txtMesa.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(),0).toString());
            txtPlatoEntrada.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(),1).toString());
            txtPlatoPrincipal.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(),2).toString());
            txtBebidas.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(),3).toString());
            txtPostre.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(),4).toString());
            txtEstado.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(),5).toString());
        }
    }//GEN-LAST:event_TablaDePedidosMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         try{
            DefaultTableModel modelo = new DefaultTableModel();
            PreparedStatement ps = null;
            ResultSet rs = null;
            TablaDePedidos.setModel(modelo);
            
            Connection cn;
            Conexion con=new Conexion();
            cn = con.getConexion();
        
            String sql = "SELECT mesa, plato_entrada, plato_principal, bebida, postre, estado FROM pedidos";  
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            
            modelo.addColumn("Mesa");
            modelo.addColumn("Platillos de entrada");
            modelo.addColumn("Platillos Principales");
            modelo.addColumn("Bebidas");
            modelo.addColumn("Postres");
            modelo.addColumn("Estado del pedido");
            
            
            
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
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(MantenedorPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MantenedorPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MantenedorPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MantenedorPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MantenedorPedidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable TablaDePedidos;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JButton jbCompletado;
    public javax.swing.JButton jbEnProceso;
    public javax.swing.JButton jbLimpiarCompletados;
    public javax.swing.JButton jbSalir;
    public javax.swing.JTextField txtBebidas;
    public javax.swing.JTextField txtEstado;
    public javax.swing.JTextField txtMesa;
    public javax.swing.JTextField txtPlatoEntrada;
    public javax.swing.JTextField txtPlatoPrincipal;
    public javax.swing.JTextField txtPostre;
    // End of variables declaration//GEN-END:variables
}
