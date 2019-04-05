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
import sv.edu.udb.proyecto.dao.ProyectoDAO;
import sv.edu.udb.proyecto.dao.exception.DAOException;
import sv.edu.udb.proyecto.modelo.Proyecto;

/**
 *
 * @author josed
 */
public class MySqlProyectoDAO implements ProyectoDAO {
    
    final String INSERT = "INSERT INTO proyecto(nombre,departamento,descripcion,documento,encargado) values(?,?,?,?,?)";
    final String UPDATE = "UPDATE proyecto SET nombre=?,departamento=?,descripcion=?,documento=?,encargado=? WHERE id=?";
    final String DELETE = "DELETE FROM proyecto WHERE id=?";
    final String GETALL = "SELECT id,nombre,departamento,descripcion,documento,encargado FROM proyecto";
    final String GETONE = "SELECT id,nombre,departamento,descripcion,documento,encargado FROM proyecto WHERE id=?";
    
    
     private Connection conn;

    public MySqlProyectoDAO(Connection conn) {
        this.conn = conn;
    }

    
    @Override
    public void insertar(Proyecto modelo) throws DAOException {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(INSERT);
            int col = 1;
            st.setString(col++, modelo.getNombre());
            st.setInt(col++, modelo.getDepartamento());
            st.setString(col++, modelo.getDescripcion());
            st.setString(col++, modelo.getDocumento());
            st.setInt(col++, modelo.getEncargado());
            if(st.executeUpdate()<0){
                throw new DAOException("Fallo al ejecutar el statement, no se pudo insertar  "+modelo.toString());
            }
        } catch (SQLException e) {
            System.out.println(e);
            throw new DAOException("No se pudo insertar  "+modelo.toString(),e);
        } finally{
            try {
                if(st!=null){
                    st.close();
                }
            } catch (SQLException e) {
                throw new DAOException("Fallo en el Statement, no se pudo insertar  "+modelo.toString(),e);
            }
        }
    }

    @Override
    public void modificar(Proyecto modelo) throws DAOException {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(UPDATE);
            int col=1;
            st.setString(col++, modelo.getNombre());
            st.setInt(col++, modelo.getDepartamento());
            st.setString(col++, modelo.getDescripcion());
            st.setString(col++, modelo.getDocumento());
            st.setInt(col++, modelo.getEncargado());
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
        }
    }

    @Override
    public void eliminar(Proyecto modelo) throws DAOException {
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

    @Override
    public List<Proyecto> obtenerTodos() throws DAOException {
        
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Proyecto> usuarios = new ArrayList<>();
        
        try {
            stat = conn.prepareStatement(GETALL);
            rs= stat.executeQuery();
            while(rs.next()){
                usuarios.add(convertir(rs));
            }
        } catch (SQLException e) {
            if(rs !=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySqlProyectoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(stat !=null){
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySqlProyectoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            throw new DAOException("Error al ejecutar el SQL",e);
        }
         return usuarios;
    }

    @Override
    public Proyecto obtener(Integer id) throws DAOException{
         PreparedStatement stat = null;
         ResultSet rs = null;
         Proyecto proyecto = null;
         try {
            stat = conn.prepareStatement(GETONE);
            stat.setInt(1, id);
            rs= stat.executeQuery();
            if(rs.next()){
                proyecto = convertir(rs);
            }else{
                throw new DAOException("No se ha encontrado registro con el id=" + id);               
            }
        } catch (SQLException e) {
            if(rs !=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySqlProyectoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(stat !=null){
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySqlProyectoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            throw new DAOException("Error al ejecutar el SQL",e);
        }
         return proyecto;
    }
    
    private Proyecto convertir(ResultSet rs) throws SQLException{
        return new Proyecto(
                rs.getInt("id"),
                rs.getString("nombre"),
                rs.getString("descripcion"),
                rs.getInt("departamento"),
                rs.getString("documento"),
                rs.getInt("encargado")
        );
    }

}
  