/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.proyecto.view;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sv.edu.udb.proyecto.Sesion;
import sv.edu.udb.proyecto.dao.exception.DAOException;
import sv.edu.udb.proyecto.modelo.Departamento;

/**
 *
 * @author josed
 */
public class IfrmDepartamento extends javax.swing.JInternalFrame {

    /**
     * Creates new form IfrmDepartamento
     */
    
    DefaultTableModel dtm;
    public static boolean activo;
    private int lastRow;
    private Departamento departamentoActual;
    
    public IfrmDepartamento() {
        activo = true;
        initComponents();
        cargarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblDepartamentos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaDescripcion = new javax.swing.JTextArea();
        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        lblId = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();

        jRadioButton1.setText("jRadioButton1");

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                close(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                cerrar(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jtblDepartamentos.setModel(new javax.swing.table.DefaultTableModel(
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
        jtblDepartamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblDepartamentosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtblDepartamentos);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Departamento"));

        jLabel1.setText("Nombre");

        jLabel2.setText("Descripción");

        txaDescripcion.setColumns(20);
        txaDescripcion.setRows(5);
        jScrollPane2.setViewportView(txaDescripcion);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");

        lblId.setText("ID:");

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnBorrar.setText("Borrar");
        btnBorrar.setEnabled(false);
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblId)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void close(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_close
      
    }//GEN-LAST:event_close

    private void cerrar(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_cerrar
        activo=false;
        this.dispose();
    }//GEN-LAST:event_cerrar

    private void jtblDepartamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblDepartamentosMouseClicked
        int fila = jtblDepartamentos.rowAtPoint(evt.getPoint());
        int columna = jtblDepartamentos.columnAtPoint(evt.getPoint());
        if((fila>-1)&&(columna>-1)){
            lblId.setText("ID:"+String.valueOf(dtm.getValueAt(fila, 0)));
            txtNombre.setText(String.valueOf(dtm.getValueAt(fila, 1)));
            txaDescripcion.setText(String.valueOf(dtm.getValueAt(fila, 2)));
            lastRow = fila;
            btnGuardar.setText("Actualizar");
            btnBorrar.setEnabled(true);
            try {
                departamentoActual = Sesion.getDatos().getDepartamentoDAO().obtener((int) dtm.getValueAt(fila,0));                
            } catch (SQLException | ClassNotFoundException | DAOException ex) {
                Logger.getLogger(IfrmDepartamento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }      // TODO add your handling code here:
    }//GEN-LAST:event_jtblDepartamentosMouseClicked

    private void cargarTabla(){
        Object[][] datos = {};
        lastRow=-1;
        String[] columnNames = Departamento.HEADERS;
        dtm = new DefaultTableModel(datos,columnNames);
        try {    
            Sesion.getDatos().getDepartamentoDAO().obtenerTodos().forEach(departamento->{
                dtm.addRow(departamento.getData());
            });
        } catch (SQLException ex) {
            Logger.getLogger(IfrmDepartamento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IfrmDepartamento.class.getName()).log(Level.SEVERE, null, ex);
        }catch (DAOException ex) {
                Logger.getLogger(IfrmDepartamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        jtblDepartamentos.setModel(dtm);

    }
    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if(departamentoActual !=null){
            try {
                Sesion.getDatos().getDepartamentoDAO().eliminar(departamentoActual);   
                JOptionPane.showMessageDialog(this, "Departamento borrado exitosamente");

            } catch (SQLException | ClassNotFoundException | DAOException ex) {
                Logger.getLogger(IfrmDepartamento.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "No se pudo borrar el departamento, asegurese no tener usuarios vinculados al departamento");
            }
        }
        cargarTabla();
        limpiar();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       
        if(btnGuardar.getText().equals("Guardar")){ //nuevo
            Departamento departamento = new Departamento();
            departamento.setNombre(txtNombre.getText());
            departamento.setDescripcion(txaDescripcion.getText());
            try {
                Sesion.getDatos().getDepartamentoDAO().insertar(departamento);
                JOptionPane.showMessageDialog(this, "Departamento guardado exitosamente");
                limpiar();
            } catch (SQLException | ClassNotFoundException | DAOException ex) {
                Logger.getLogger(IfrmDepartamento.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "No se pudo guardar el departamento");
            }
           
        }else{ //actualizar
            try{
                departamentoActual.setNombre(txtNombre.getText());
                departamentoActual.setDescripcion(txaDescripcion.getText());
                Sesion.getDatos().getDepartamentoDAO().modificar(departamentoActual);
                JOptionPane.showMessageDialog(this, "Departamento actualizado exitosamente");
                limpiar();
            }catch (SQLException | ClassNotFoundException | DAOException ex) {
                Logger.getLogger(IfrmDepartamento.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "No se pudo actualizar el departamento");
            }
        }
        cargarTabla();
    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtblDepartamentos;
    private javax.swing.JLabel lblId;
    private javax.swing.JTextArea txaDescripcion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    private void limpiar() {
        lblId.setText("ID:");
        txtNombre.setText("");
        txaDescripcion.setText("");
        btnGuardar.setText("Guardar");        
        btnBorrar.setEnabled(false);
        departamentoActual = null;   
    }
}
