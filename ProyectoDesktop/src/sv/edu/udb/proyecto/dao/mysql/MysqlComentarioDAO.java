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
import sv.edu.udb.proyecto.dao.ComentarioDAO;
import sv.edu.udb.proyecto.dao.exception.DAOException;
import sv.edu.udb.proyecto.modelo.Comentario;
/**
 *
 * @author Ozkar
 */
public class MysqlComentarioDAO implements ComentarioDAO{
    
    Connection conn;
    
    final String INSERT = "INSERT INTO comentario(nombre,descripcion,usuario,bitacora_id,creado_el) VALUES(?,?,?,?,?)";
    final String UPDATE = "UPDATE comentario SET nombre=?, descripcion=?, usuario=?, bitacora_id=?, creado_el=? WHERE id=?";
    final String DELETE = "DELETE FROM comentario WHERE id=?";
    final String GETALL = "SELECT id,nombre,descripcion,usuario,bitacora_id,creado_el FROM comentario";
    final String GETONE = "SELECT id,nombre,descripcion,usuario,bitacora_id,creado_el FROM comentario WHERE id=?";
    
    public MysqlComentarioDAO(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insertar(Comentario modelo) throws DAOException {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(INSERT);
            int col = 1;
            st.setString(col++, modelo.getNombre());
            st.setString(col++, modelo.getDescripcion());
            st.setInt(col++, modelo.getUsuario());
            st.setInt(col++, modelo.getBitacora_id());
            st.setDate(col++, new Date(modelo.getCreado_el().getTime()));            
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
    public void modificar(Comentario modelo) throws DAOException {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(UPDATE);
            int col = 1;
            st.setString(col++, modelo.getNombre());
            st.setString(col++, modelo.getDescripcion());
            st.setInt(col++, modelo.getUsuario());
            st.setInt(col++, modelo.getBitacora_id());
            st.setDate(col++, new Date(modelo.getCreado_el().getTime()));
            st.setInt(col++, modelo.getId());
            if(st.executeUpdate()<0){
                throw new DAOException("Fallo al ejecutar el statement, no se pudo actualizar"+modelo.toString());
            }
        } catch (SQLException e) {
            throw new DAOException("No se pudo insertar  "+modelo.toString(),e);
        } finally{
            try {
                if(st!=null){
                    st.close();
                }
            } catch (SQLException e) {
                throw new DAOException("Fallo en el Statement, no se pudo actualizar"+modelo.toString(),e);
            }
        }
    }

    @Override
    public void eliminar(Comentario modelo) throws DAOException {
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
    
    private Comentario convertir(ResultSet rs) throws SQLException{
        return new Comentario(
                rs.getInt("id"),
                rs.getString("nombre"),
                rs.getString("descripcion"),
                rs.getInt("usuario"),
                rs.getInt("bitacora_id"),
                rs.getDate("creado_el")                
        );
    }
    
    @Override
    public List<Comentario> obtenerTodos() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Comentario> comentarios = new ArrayList<>();
        
        try {
            stat = conn.prepareStatement(GETALL);
            rs= stat.executeQuery();
            while(rs.next()){
                comentarios.add(convertir(rs));
            }
        } catch (SQLException e) {
            if(rs !=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MysqlComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(stat !=null){
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MysqlComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            throw new DAOException("Error al ejecutar el SQL",e);
        }
         return comentarios;
    }

    @Override
    public Comentario obtener(Integer id) throws DAOException {
        PreparedStatement stat = null;
         ResultSet rs = null;
         Comentario comentario = null;
         try {
            stat = conn.prepareStatement(GETONE);
            stat.setInt(1, id);
            rs= stat.executeQuery();
            if(rs.next()){
                comentario = convertir(rs);
            }else{
                throw new DAOException("No se ha encontrado registro con el id=" + id);               
            }
        } catch (SQLException e) {
            if(rs !=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MysqlComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(stat !=null){
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MysqlComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            throw new DAOException("Error al ejecutar el SQL",e);
        }
         return comentario;
    }
    
}
