/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.proyecto.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sv.edu.udb.proyecto.dao.RolDAO;
import sv.edu.udb.proyecto.dao.exception.DAOException;
import sv.edu.udb.proyecto.modelo.Rol;

/**
 *
 * @author josed
 */
public class MySqlRolDAO implements RolDAO {

    Connection conn;
    final String GETALL = "SELECT id,nombre,descripcion FROM rol";
    final String GETONE = "SELECT id,nombre,descripcion FROM rol WHERE id=?";

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
    public List<Rol> obtenerTodos() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Rol> roles = new ArrayList<>();

        try {
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                roles.add(convertir(rs));
            }
        } catch (SQLException e) {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySqlRolDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySqlRolDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            throw new DAOException("Error al ejecutar el SQL", e);
        }
        return roles;
    }

    @Override
    public Rol obtener(Integer id) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Rol rol = null;
        try {
            stat = conn.prepareStatement(GETONE);
            stat.setInt(1, id);
            rs = stat.executeQuery();
            if (rs.next()) {
                rol = convertir(rs);
            } else {
                throw new DAOException("No se ha encontrado registro con el id=" + id);
            }
        } catch (SQLException e) {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySqlRolDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySqlRolDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            throw new DAOException("Error al ejecutar el SQL", e);
        }
        return rol;
    }

    private Rol convertir(ResultSet rs) throws SQLException {
        return new Rol(
                rs.getInt("id"),
                rs.getString("nombre"),
                rs.getString("descripcion")
        );
    }

}
