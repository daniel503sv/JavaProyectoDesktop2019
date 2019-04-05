/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.proyecto.dao;

import java.util.List;
import sv.edu.udb.proyecto.dao.exception.DAOException;
import sv.edu.udb.proyecto.modelo.Departamento;
import sv.edu.udb.proyecto.modelo.Rol;
import sv.edu.udb.proyecto.modelo.Usuario;

/**
 *
 * @author josed
 */
public interface UsuarioDAO extends DAO<Usuario,Integer> {
    public Usuario ingresar(String usuario,String password) throws DAOException;
    public List<Usuario> obtenerUsuariosRol(Rol rol) throws DAOException;
    public List<Usuario> obtenerUsuariosDepartamento(Departamento departamento) throws DAOException;
    public List<Usuario> obtenerUsuariosRolDepartamento(Rol rol,Departamento departamento) throws DAOException;
}
