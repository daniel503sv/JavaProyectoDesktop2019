/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.proyecto;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

/**
 *
 * @author josed
 */
public class ProyectoDesktop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ProyectoDesktop.class.getName()).log(Level.SEVERE, null, ex);
            }
            tarea(); 
        }).start();
    }
    
    public static void tarea(){
    
    }
}
