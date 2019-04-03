/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.proyecto.utils;

import javax.swing.JOptionPane;

/**
 *
 * @author josed
 */
public class Utils {
    public static void mostrarMensaje(String titulo,String texto){
        JOptionPane.showMessageDialog(null, texto,titulo,JOptionPane.PLAIN_MESSAGE);
    }
}
