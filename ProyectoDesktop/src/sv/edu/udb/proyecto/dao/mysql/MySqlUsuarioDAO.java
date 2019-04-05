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
import sv.edu.udb.proyecto.dao.UsuarioDAO;
import sv.edu.udb.proyecto.dao.exception.DAOException;
import sv.edu.udb.proyecto.modelo.Departamento;
import sv.edu.udb.proyecto.modelo.Rol;
import sv.edu.udb.proyecto.modelo.Usuario;

/**
 *
 * @author josed
 */
public class MySqlUsuarioDAO implements UsuarioDAO {
    
    final String INSERT = "INSERT INTO usuario(nombre,apellido,correo,telefono,password,departamento_id,rol_id,fecha_creacion) values(?,?,?,?,SHA2(?,256),?,?,?)";
    final String UPDATE = "UPDATE usuario SET nombre=?,apellido=?,correo=?,telefono=?,password=SHA2(?,256),departamento_id=?,rol_id=?,fecha_creacion=? WHERE id=?";
    final String UPDATE_SIN_PASS = "UPDATE usuario SET nombre=?,apellido=?,correo=?,telefono=?,departamento_id=?,rol_id=?,fecha_creacion=? WHERE id=?";
    final String DELETE = "DELETE FROM usuario WHERE id=?";
    final String GETALL = "SELECT id,nombre,apellido,correo,telefono,password,departamento_id,rol_id,fecha_creacion FROM usuario";
    final String BY_ROL = " WHERE rol_id=?";
    final String BY_DEPARTAMENTO = " WHERE departamento_id=?";
    final String BY_ROL_DEPARTAMENTO = " WHERE rol_id=? AND departamento_id=?";
    final String GETONE = "SELECT id,nombre,apellido,correo,telefono,password,departamento_id,rol_id,fecha_creacion FROM usuario WHERE id=?";
    final String GETUSER = "SELECT id,nombre,apellido,correo,telefono,password,departamento_id,rol_id,fecha_creacion FROM usuario WHERE correo=? AND password=SHA2(?,256)";
    
     private Connection conn;

    public MySqlUsuarioDAO(Connection conn) {
        this.conn = conn;
    }

    
    @Override
    public void insertar(Usuario modelo) throws DAOException {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(INSERT);
            int col = 1;
            st.setString(col++, modelo.getNombre());
            st.setString(col++, modelo.getApellido());
            st.setString(col++, modelo.getCorreo());
            st.setString(col++, modelo.getTelefono());
            st.setString(col++, modelo.getPassword());
            st.setInt(col++, modelo.getDepartamentoId());
            st.setInt(col++, modelo.getRolId());
            st.setDate(col++, new Date(modelo.getFechaCreacion().getTime()));
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
        }
    }

    @Override
    public void modificar(Usuario modelo) throws DAOException {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement((modelo.getPassword()!=null)?UPDATE:UPDATE_SIN_PASS);
            int col=1;
            st.setString(col++, modelo.getNombre());
            st.setString(col++, modelo.getApellido());
            st.setString(col++, modelo.getCorreo());
            st.setString(col++, modelo.getTelefono());
            if((modelo.getPassword()!=null)){
                st.setString(col++, modelo.getPassword());
            }
            st.setInt(col++, modelo.getDepartamentoId());
            st.setInt(col++, modelo.getRolId());
            st.setDate(col++, new Date(modelo.getFechaCreacion().getTime()));
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
    public void eliminar(Usuario modelo) throws DAOException {
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
    public List<Usuario> obtenerTodos() throws DAOException {
        
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<>();
        
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
                    Logger.getLogger(MySqlUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(stat !=null){
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySqlUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            throw new DAOException("Error al ejecutar el SQL",e);
        }
         return usuarios;
    }

    @Override
    public Usuario obtener(Integer id) throws DAOException{
         PreparedStatement stat = null;
         ResultSet rs = null;
         Usuario usuario = null;
         try {
            stat = conn.prepareStatement(GETONE);
            stat.setInt(1, id);
            rs= stat.executeQuery();
            if(rs.next()){
                usuario = convertir(rs);
            }else{
                throw new DAOException("No se ha encontrado registro con el id=" + id);               
            }
        } catch (SQLException e) {
            if(rs !=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySqlUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(stat !=null){
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySqlUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            throw new DAOException("Error al ejecutar el SQL",e);
        }
         return usuario;
    }
    
    
    @Override
    public Usuario ingresar(String correo, String password) throws DAOException {
        PreparedStatement stat = null;
         ResultSet rs = null;
         Usuario usuario = null;
         try {
            stat = conn.prepareStatement(GETUSER);
            stat.setString(1, correo);
            stat.setString(2, password);
            rs= stat.executeQuery();
            if(rs.next()){
                usuario = convertir(rs);
            }else{
                throw new DAOException("No se ha encontrado registro con el correo=" + correo);               
            }
        } catch (SQLException e) {
            if(rs !=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySqlUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(stat !=null){
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySqlUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            throw new DAOException("Error al ejecutar el SQL",e);
        }
         return usuario;
    }
    
    private Usuario convertir(ResultSet rs) throws SQLException{
        return new Usuario(
                rs.getInt("id"),
                rs.getString("nombre"),
                rs.getString("apellido"),
                rs.getString("correo"),
                rs.getString("telefono"),
                rs.getInt("departamento_id"),
                rs.getInt("rol_id"),
                new Date(rs.getDate("fecha_creacion").getTime())
        );
    }

    @Override
    public List<Usuario> obtenerUsuariosRol(Rol rol) throws DAOException {
   
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<>();
        
        try {
            stat = conn.prepareStatement(GETALL+BY_ROL);
            stat.setInt(1, rol.getId());
            rs= stat.executeQuery();
            while(rs.next()){
                usuarios.add(convertir(rs));
            }
        } catch (SQLException e) {
            if(rs !=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySqlUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(stat !=null){
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySqlUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            throw new DAOException("Error al ejecutar el SQL",e);
        }
         return usuarios;    
    }

    @Override
    public List<Usuario> obtenerUsuariosDepartamento(Departamento departamento) throws DAOException {
  PreparedStatement stat = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<>();
        
        try {
            stat = conn.prepareStatement(GETALL+BY_DEPARTAMENTO);
            stat.setInt(1, departamento.getId());

            rs= stat.executeQuery();
            while(rs.next()){
                usuarios.add(convertir(rs));
            }
        } catch (SQLException e) {
            if(rs !=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySqlUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(stat !=null){
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySqlUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            throw new DAOException("Error al ejecutar el SQL",e);
        }
         return usuarios;        }

    @Override
    public List<Usuario> obtenerUsuariosRolDepartamento(Rol rol, Departamento departamento) throws DAOException {
  PreparedStatement stat = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<>();
        
        try {
            stat = conn.prepareStatement(GETALL+BY_ROL_DEPARTAMENTO);
            stat.setInt(1, rol.getId());
            stat.setInt(2, departamento.getId());
            rs= stat.executeQuery();
            
            while(rs.next()){
                usuarios.add(convertir(rs));
            }
        } catch (SQLException e) {
            if(rs !=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySqlUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(stat !=null){
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySqlUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            throw new DAOException("Error al ejecutar el SQL",e);
        }
         return usuarios;    
    }

}
  