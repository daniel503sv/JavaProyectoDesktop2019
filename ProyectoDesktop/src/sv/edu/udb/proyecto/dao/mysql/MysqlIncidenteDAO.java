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
import sv.edu.udb.proyecto.dao.IncidenteDAO;
import sv.edu.udb.proyecto.dao.exception.DAOException;
import sv.edu.udb.proyecto.modelo.Incidente;
/**
 *
 * @author Ozkar
 */
public class MysqlIncidenteDAO implements IncidenteDAO{
    
    Connection conn;
    
    final String INSERT = "INSERT INTO incidente(nombre,descripcion,desarrollador,probador,fecha_creacion,estado,id_proyecto) VALUES(?,?,?,?,?,?,?)";
    final String UPDATE = "UPDATE incidente SET nombre=?,descripcion=?,desarrollador=?,probador=?,fecha_creacion=?,estado=?,id_proyecto=? WHERE id=?";
    final String DELETE = "DELETE FROM incidente WHERE id=?";
    final String GETALL = "SELECT id,nombre,descripcion,desarrollador,probador,fecha_creacion,estado,id_proyecto FROM incidente";
    final String GETONE = "SELECT id,nombre,descripcion,desarrollador,probador,fecha_creacion,estado,id_proyecto FROM incidente WHERE id=?";
    
    public MysqlIncidenteDAO(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insertar(Incidente modelo) throws DAOException {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(INSERT);
            int col = 1;
            st.setString(col++, modelo.getNombre());
            st.setString(col++, modelo.getDescripcion());
            st.setInt(col++, modelo.getDesarrollador());
            st.setInt(col++, modelo.getProbador());            
            st.setDate(col++, new Date(modelo.getFechaCreacion().getTime()));
            st.setInt(col++, modelo.getEstado());
            st.setInt(col++, modelo.getIdProyecto());
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
    public void modificar(Incidente modelo) throws DAOException {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(UPDATE);
            int col = 1;
            st.setString(col++, modelo.getNombre());
            st.setString(col++, modelo.getDescripcion());
            st.setInt(col++, modelo.getDesarrollador());
            st.setInt(col++, modelo.getProbador());            
            st.setDate(col++, new Date(modelo.getFechaCreacion().getTime()));
            st.setInt(col++, modelo.getEstado());
            st.setInt(col++, modelo.getIdProyecto());
            st.setString(col++, modelo.getId());
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
    public void eliminar(Incidente modelo) throws DAOException {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(DELETE);
            int col=1;
            st.setString(col++, modelo.getId());
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
    
    private Incidente convertir(ResultSet rs) throws SQLException{
    return new Incidente(
                rs.getString("id"),
                rs.getString("nombre"),
                rs.getString("descripcion"),
                rs.getInt("desarrollador"),
                rs.getInt("probador"),
                rs.getDate("fecha_creacion"),
                rs.getInt("estado"),
                rs.getInt("id_proyecto")
        );
    }
    
    @Override
    public List<Incidente> obtenerTodos() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Incidente> incidentes = new ArrayList<>();
        
        try {
            stat = conn.prepareStatement(GETALL);
            rs= stat.executeQuery();
            while(rs.next()){
                incidentes.add(convertir(rs));
            }
        } catch (SQLException e) {
            if(rs !=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MysqlIncidenteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(stat !=null){
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MysqlIncidenteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            throw new DAOException("Error al ejecutar el SQL",e);
        }
         return incidentes;
    }

    @Override
    public Incidente obtener(String id) throws DAOException {
        PreparedStatement stat = null;
         ResultSet rs = null;
         Incidente incidente = null;
         try {
            stat = conn.prepareStatement(GETONE);
            stat.setString(1, id);
            rs= stat.executeQuery();
            if(rs.next()){
                incidente = convertir(rs);
            }else{
                throw new DAOException("No se ha encontrado registro con el id=" + id);               
            }
        } catch (SQLException e) {
            if(rs !=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MysqlIncidenteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(stat !=null){
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MysqlIncidenteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            throw new DAOException("Error al ejecutar el SQL",e);
        }
         return incidente;
    }
    
    
}
