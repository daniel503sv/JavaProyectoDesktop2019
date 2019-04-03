/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.proyecto;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import sv.edu.udb.proyecto.dao.DAOManager;
import sv.edu.udb.proyecto.dao.exception.DAOException;
import sv.edu.udb.proyecto.dao.mysql.MySqlDAOManager;
import sv.edu.udb.proyecto.modelo.Usuario;

/**
 *
 * @author josed
 */
public class Test {
    public static void main(String[] args) throws SQLException, IOException, FileNotFoundException, ClassNotFoundException, DAOException {
        
        DAOManager datos = new MySqlDAOManager("localhost","root","","proyecto");
        System.out.println("Ingresando");
        Usuario usuario = datos.getUsuarioDAO().ingresar("mail@test.com", "password");
        if(usuario!=null){
            System.out.println("Exito");
        }else{
            System.out.println("EPIC FAIL");
        }
    }

}
