/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.proyecto.dao.mysql;

import java.sql.Connection;
import java.util.List;
import sv.edu.udb.proyecto.dao.RolDAO;
import sv.edu.udb.proyecto.dao.exception.DAOException;
import sv.edu.udb.proyecto.modelo.Rol;

/**
 *
 * @author josed
 */
public class MySqlRolDAO implements RolDAO{

    Connection conn;
    public MySqlRolDAO(Connection conn) {
        this.conn = conn;
    }
    @Override
    public void insertar(Rol modelo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Rol modelo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Rol modelo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Rol> obtenerTodos() throws DAOException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Rol obtener(Integer id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
