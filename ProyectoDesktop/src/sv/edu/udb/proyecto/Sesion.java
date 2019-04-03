/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.proyecto;

import java.sql.SQLException;
import sv.edu.udb.proyecto.dao.DAOManager;
import sv.edu.udb.proyecto.dao.exception.DAOException;
import sv.edu.udb.proyecto.dao.mysql.MySqlDAOManager;
import sv.edu.udb.proyecto.modelo.Rol;
import sv.edu.udb.proyecto.modelo.Usuario;

/**
 *
 * @author josed
 */
public class Sesion {

    private static Usuario usuario;
    private static DAOManager datos;
    private static String lenguaje;

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        Sesion.usuario = usuario;
    }

    public static String getLenguaje() {
        return lenguaje;
    }

    public static void setLenguaje(String lenguaje) {
        Sesion.lenguaje = lenguaje;
    }
    
    public static Rol getRol() throws SQLException, ClassNotFoundException, DAOException{
        if(usuario!=null){
            return getDatos().getRolDAO().obtener(usuario.getRolId());
        }
        return null;
    }

    public static DAOManager getDatos() throws SQLException, ClassNotFoundException {
        if (datos == null) {
            datos = new MySqlDAOManager("localhost", "root", "", "proyecto");
        }
        return datos;
    }
}
