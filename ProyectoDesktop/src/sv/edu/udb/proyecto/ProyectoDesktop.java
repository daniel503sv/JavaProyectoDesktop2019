/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.proyecto;

import java.util.logging.Level;
import java.util.logging.Logger;
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
        FrmLogin frm = new FrmLogin();
        frm.setVisible(true);
    }
    
    public static void tarea(){
        System.out.println("Tarea programada");
    }
}
