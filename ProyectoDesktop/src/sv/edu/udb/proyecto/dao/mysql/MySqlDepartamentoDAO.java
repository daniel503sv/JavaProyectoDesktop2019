/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.proyecto.dao.mysql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sv.edu.udb.proyecto.dao.DepartamentoDAO;
import sv.edu.udb.proyecto.dao.exception.DAOException;
import sv.edu.udb.proyecto.modelo.Departamento;
import sv.edu.udb.proyecto.modelo.Usuario;

/**
 *
 * @author josed
 */
public class MySqlDepartamentoDAO implements DepartamentoDAO{

    Connection conn;
    
    final String INSERT = "INSERT INTO departamento(nombre,descripcion) values(?,?)";
    final String UPDATE = "UPDATE departamento SET nombre=?,descripcion=? WHERE id=?";
    final String DELETE = "DELETE FROM departamento WHERE id=?";
    final String GETALL = "SELECT id,nombre,descripcion FROM departamento";
    final String GETONE = "SELECT id,nombre,descripcion FROM departamento WHERE id=?";
  
    public MySqlDepartamentoDAO(Connection conn) {
        this.conn = conn;
    }
    @Override
    public void insertar(Departamento modelo) throws DAOException{
 PreparedStatement st = null;
        try {
            st = conn.prepareStatement(INSERT);
            int col = 1;
            st.setString(col++, modelo.getNombre());
            st.setString(col++, modelo.getDescripcion());
            if(st.executeUpdate()<0){
                throw new DAOException("Fallo al ejecutar el statement, no se pudo insertar  "+modelo.toString());
            }
        } catch (SQLException e) {
            throw new DAOException("No se pudo insertar  "+modelo.toString(),e);
        } finally{
            try {
                if(st!=null){
                    st.close();
                }
            } catch (SQLException e) {
                throw new DAOException("Fallo en el Statement, no se pudo insertar  "+modelo.toString(),e);
            }
        }    }

    @Override
    public void modificar(Departamento modelo) throws DAOException{
 PreparedStatement st = null;
        try {
            st = conn.prepareStatement(UPDATE);
            int col=1;
            st.setString(col++, modelo.getNombre());
            st.setString(col++, modelo.getDescripcion());
            st.setInt(col++, modelo.getId());
            if(st.executeUpdate()<0){
                throw new DAOException("Fallo al ejecutar el statement, no se pudo actualizar "+modelo.toString());
            }
        } catch (SQLException e) {
            throw new DAOException("No se pudo actualizar "+modelo.toString(),e);
        } finally{
            try {
                if(st!=null){
                    st.close();
                }
            } catch (SQLException e) {
                throw new DAOException("Fallo en el Statement, no se pudo actualizar "+modelo.toString(),e);
            }
        }    }

    @Override
    public void eliminar(Departamento modelo) throws DAOException{
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(DELETE);
            int col=1;
            st.setInt(col++, modelo.getId());
            if(st.executeUpdate()<0){
                throw new DAOException("Fallo al ejecutar el statement, no se pudo borrar "+modelo.toString());
            }
        } catch (SQLException e) {
            throw new DAOException("No se pudo borrar "+modelo.toString(),e);
        } finally{
            try {
                if(st!=null){
                    st.close();
                }
            } catch (SQLException e) {
                throw new DAOException("Fallo en el Statement, no se pudo borrar "+modelo.toString(),e);
            }
        }
    }
    
    private Departamento convertir(ResultSet rs) throws SQLException{
        return new Departamento(
                rs.getInt("id"),
                rs.getString("nombre"),
                rs.getString("descripcion")
        );
    }

    @Override
    public List<Departamento> obtenerTodos() throws DAOException{
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Departamento> departamentos = new ArrayList<>();
        
        try {
            stat = conn.prepareStatement(GETALL);
            rs= stat.executeQuery();
            while(rs.next()){
                departamentos.add(convertir(rs));
            }
        } catch (SQLException e) {
            if(rs !=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySqlDepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(stat !=null){
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySqlDepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            throw new DAOException("Error al ejecutar el SQL",e);
        }
         return departamentos;
    }

    @Override
    public Departamento obtener(Integer id) throws DAOException {
  PreparedStatement stat = null;
         ResultSet rs = null;
         Departamento departamento = null;
         try {
            stat = conn.prepareStatement(GETONE);
            stat.setInt(1, id);
            rs= stat.executeQuery();
            if(rs.next()){
                departamento = convertir(rs);
            }else{
                throw new DAOException("No se ha encontrado registro con el id=" + id);               
            }
        } catch (SQLException e) {
            if(rs !=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySqlDepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(stat !=null){
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySqlDepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            throw new DAOException("Error al ejecutar el SQL",e);
        }
         return departamento;
    }    
}
