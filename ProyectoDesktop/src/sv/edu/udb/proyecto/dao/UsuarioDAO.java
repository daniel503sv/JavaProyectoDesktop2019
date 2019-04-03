/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.proyecto.dao;

import sv.edu.udb.proyecto.dao.exception.DAOException;
import sv.edu.udb.proyecto.modelo.Usuario;

/**
 *
 * @author josed
 */
public interface UsuarioDAO extends DAO<Usuario,Integer> {
    public Usuario ingresar(String usuario,String password) throws DAOException;
}
