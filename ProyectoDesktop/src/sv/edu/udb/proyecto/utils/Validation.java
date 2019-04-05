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
    private static final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
    private static final String ALPHANUMERIC_DASH_REGEX = "[a-zA-z\\s]*";
    private static final String NUMERIC_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
    
    public static boolean alphanumeric_dash(String text){
        if(text == null){
            return false;
        }
        return text.matches(ALPHANUMERIC_DASH_REGEX);
    }
    
    public static boolean numeric(String text){
        if(text == null){
            return false;
        }
        return text.matches(NUMERIC_REGEX);
    }

    public static boolean email(String text) {
        if(text == null){
            return false;
        }
        return text.matches(EMAIL_REGEX);
    }
    
}
