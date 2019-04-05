/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.proyecto.view;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sv.edu.udb.proyecto.Sesion;
import sv.edu.udb.proyecto.dao.exception.DAOException;

/**
 *
 * @author josed
 */
public class FrmMaster extends javax.swing.JFrame {

    /**
     * Creates new form FrmMaster
     */
    public FrmMaster() {
        if (Sesion.getUsuario() != null) {
            initComponents();
        } else {
            this.dispose();
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

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        omiUsuarios = new javax.swing.JMenuItem();
        omiDepartamentos = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        omiProyectos = new javax.swing.JMenuItem();
        omiIncidentes = new javax.swing.JMenuItem();
        omiAsignar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        omiAprobar = new javax.swing.JMenuItem();
        omiBitacora = new javax.swing.JMenuItem();
        omiRevisar = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        omiDatos = new javax.swing.JMenuItem();
        omiTodos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                close(evt);
            }
        });

        fileMenu.setMnemonic('f');
        fileMenu.setText("Administrar");

        omiUsuarios.setMnemonic('o');
        omiUsuarios.setText("Usuarios");
        omiUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                omiUsuariosActionPerformed(evt);
            }
        });
        fileMenu.add(omiUsuarios);

        omiDepartamentos.setMnemonic('s');
        omiDepartamentos.setText("Departamentos");
        omiDepartamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                omiDepartamentosActionPerformed(evt);
            }
        });
        fileMenu.add(omiDepartamentos);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Proyectos");

        omiProyectos.setMnemonic('t');
        omiProyectos.setText("Proyectos");
        omiProyectos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                omiProyectosActionPerformed(evt);
            }
        });
        editMenu.add(omiProyectos);

        omiIncidentes.setMnemonic('y');
        omiIncidentes.setText("Incidentes");
        omiIncidentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                omiIncidentesActionPerformed(evt);
            }
        });
        editMenu.add(omiIncidentes);

        omiAsignar.setMnemonic('p');
        omiAsignar.setText("Asignar");
        editMenu.add(omiAsignar);

        menuBar.add(editMenu);

        jMenu2.setText("Incidentes");

        omiAprobar.setText("Aprobar");
        omiAprobar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                omiAprobarActionPerformed(evt);
            }
        });
        jMenu2.add(omiAprobar);

        omiBitacora.setText("Bitacora");
        omiBitacora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                omiBitacoraActionPerformed(evt);
            }
        });
        jMenu2.add(omiBitacora);

        omiRevisar.setText("Revisar");
        omiRevisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                omiRevisarActionPerformed(evt);
            }
        });
        jMenu2.add(omiRevisar);

        menuBar.add(jMenu2);

        jMenu1.setText("Información");

        omiDatos.setText("Datos");
        omiDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                omiDatosActionPerformed(evt);
            }
        });
        jMenu1.add(omiDatos);

        omiTodos.setText("Incidentes");
        omiTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                omiTodosActionPerformed(evt);
            }
        });
        jMenu1.add(omiTodos);

        menuBar.add(jMenu1);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void omiDepartamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_omiDepartamentosActionPerformed
        if (!IfrmDepartamento.activo) {
            IfrmDepartamento frmDepa = new IfrmDepartamento();
            this.desktopPane.add(frmDepa);
            frmDepa.show();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_omiDepartamentosActionPerformed

    private void omiUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_omiUsuariosActionPerformed
        try {
            if (!IfrmUsuario.activo && (Sesion.getRol().getId()==1 || Sesion.getRol().getId()==2)) {
                IfrmUsuario frmUsr = new IfrmUsuario();
                this.desktopPane.add(frmUsr);
                frmUsr.show();
            }
        } catch (SQLException | ClassNotFoundException | DAOException ex) {
            Logger.getLogger(FrmMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_omiUsuariosActionPerformed

    private void omiProyectosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_omiProyectosActionPerformed
        if (!IfrmProyecto.activo) {
            IfrmProyecto proyecto = new IfrmProyecto();
            this.desktopPane.add(proyecto);
            proyecto.show();

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_omiProyectosActionPerformed

    private void close(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_close
        try {
            Sesion.getDatos().close();        // TODO add your handling code here:
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FrmMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_close

    private void omiDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_omiDatosActionPerformed
        if (!IfrmInformacion.activo) {
            IfrmInformacion frm = new IfrmInformacion();
            this.desktopPane.add(frm);
            frm.show();
        }
    }//GEN-LAST:event_omiDatosActionPerformed

    private void omiIncidentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_omiIncidentesActionPerformed

        if (!IfrmIncidente.activo) {
            IfrmIncidente frm = new IfrmIncidente();
            this.desktopPane.add(frm);
            frm.show();
        }
    }//GEN-LAST:event_omiIncidentesActionPerformed

    private void omiAprobarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_omiAprobarActionPerformed
        if (!IfrmAprobar.activo) {
            IfrmAprobar frm = new IfrmAprobar();
            this.desktopPane.add(frm);
            frm.show();
        }    }//GEN-LAST:event_omiAprobarActionPerformed

    private void omiBitacoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_omiBitacoraActionPerformed
        if (!IfrmBitacora.activo) {
            IfrmBitacora frm = new IfrmBitacora();
            this.desktopPane.add(frm);
            frm.show();
        }  // TODO add your handling code here:
    }//GEN-LAST:event_omiBitacoraActionPerformed

    private void omiRevisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_omiRevisarActionPerformed
        if (!IfrmProbar.activo) {
            IfrmProbar frm = new IfrmProbar();
            this.desktopPane.add(frm);
            frm.show();
        }
    }//GEN-LAST:event_omiRevisarActionPerformed

    private void omiTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_omiTodosActionPerformed
        if (!IfrmTodosIncidentes.activo) {
            IfrmTodosIncidentes frm = new IfrmTodosIncidentes();
            this.desktopPane.add(frm);
            frm.show();
        }    }//GEN-LAST:event_omiTodosActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMaster().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem omiAprobar;
    private javax.swing.JMenuItem omiAsignar;
    private javax.swing.JMenuItem omiBitacora;
    private javax.swing.JMenuItem omiDatos;
    private javax.swing.JMenuItem omiDepartamentos;
    private javax.swing.JMenuItem omiIncidentes;
    private javax.swing.JMenuItem omiProyectos;
    private javax.swing.JMenuItem omiRevisar;
    private javax.swing.JMenuItem omiTodos;
    private javax.swing.JMenuItem omiUsuarios;
    // End of variables declaration//GEN-END:variables

}
