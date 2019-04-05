/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.proyecto;

import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import sv.edu.udb.proyecto.dao.exception.DAOException;
import sv.edu.udb.proyecto.view.FrmLogin;

/**
 *
 * @author josed
 */
public class ProyectoDesktop {

    /**
     * @param args the command line arguments
     */
    public static boolean estadoTarea;
    public static void main(String[] args) {
        estadoTarea = true;
        FrmLogin frm = new FrmLogin();
        frm.setVisible(true);
        tarea();
        new Thread(() -> {
            try {
                while(estadoTarea){
                    Thread.sleep(10000);
                    tarea(); 
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(ProyectoDesktop.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }).start();
 
    }
    
    public static void tarea(){
        try {
            System.out.println("Tarea programada");
            if(Sesion.getDatos()!=null){
                System.out.println("Revisando datos");
                Sesion.getDatos().getIncidenteDAO().obtenerTodos().stream().filter(inc->{
                    if((inc.getEstado()==2) && inc.getFechaEntrega()!=null){
                        return (inc.getFechaEntrega().compareTo(new Date()))>=0;
                    }
                    return false;
                }).forEach(in->{
                    try {
                        in.setEstado(8);
                        Sesion.getDatos().getIncidenteDAO().modificar(in);
                    } catch (SQLException | ClassNotFoundException | DAOException ex) {
                        System.out.println("No se pudo actualizar el estado del incidente "+in.getId());
                    }
                });
            }
        } catch (DAOException | SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
            System.out.println("No se pudo completar la revision");
        }
    }
}
