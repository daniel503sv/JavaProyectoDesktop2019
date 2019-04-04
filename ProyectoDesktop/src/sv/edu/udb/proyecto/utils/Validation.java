/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.proyecto.utils;

/**
 *
 * @author josed
 */
public class Validation {
    public static boolean alphanumeric_dash(String text){
        if(text == null){
            return false;
        }
        return text.matches("[a-zA-z\\s]*");
    }
    
    public static boolean numeric(String text){
        if(text == null){
            return false;
        }
        return text.matches("^[0-9]");
    }
    
}
