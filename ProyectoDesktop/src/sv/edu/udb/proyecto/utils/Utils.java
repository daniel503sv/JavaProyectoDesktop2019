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
     public static String randNumber(int size) {
        if (size > 10) {
            return null;
        }
        int[] myNumbers = new int[10];
        String result = "";
        int index;
        for (int i = 0; i < myNumbers.length; i++) {
            myNumbers[i] = i;
        }
        for (int i = 0; i < size; i++) {
            index = (int) Math.floor(Math.random() * 10);
            if (myNumbers[index] >= 0) {
                result = result + myNumbers[index] + "";
                myNumbers[index] = -1;
            } else {
                i--;
            }
        }
        return result;
    }
}
