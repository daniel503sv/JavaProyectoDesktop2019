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
import sv.edu.udb.proyecto.dao.exception.DAOException;
import sv.edu.udb.proyecto.dao.BitacoraDAO;
import sv.edu.udb.proyecto.modelo.Bitacora;
/**
 *
 * @author Ozkar
 */
public class MysqlBitacoraDAO implements BitacoraDAO {
    
    Connection conn;
    
    final String INSERT = "INSERT INTO bitacora(id_incidente,usuario,bitacoracol,razon_rechazo,porcentaje,documento,creado_el,actualizado_el) VALUES (?,?,?,?,?,?,?,?)";
    final String UPDATE = "UPDATE bitacora SET id_incidente=?,usuario=?,bitacoracol=?,razon_rechazo=?,porcentaje=?,documento=?,creado_el=?,actualizado_el=? WHERE id=?";
    final String DELETE = "DELETE FROM bitacora WHERE id=?";
    final String GETALL = "SELECT id,id_incidente,usuario,bitacoracol,razon_rechazo,porcentaje,documento,creado_el,actualizado_el FROM bitacora";
    final String GETONE = "SELECT id,id_incidente,usuario,bitacoracol,razon_rechazo,porcentaje,documento,creado_el,actualizado_el FROM bitacora WHERE id=?";
    
    public MysqlBitacoraDAO(Connection conn){
        this.conn = conn;
    }
    
    @Override
    public void insertar(Bitacora modelo) throws DAOException {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(INSERT);
            int col = 1;
            st.setString(col++, modelo.getId_incidente());
            st.setInt(col++, modelo.getUsuario());
            st.setString(col++, modelo.getBitacoracol());
            st.setString(col++, modelo.getRazonRechazo());
            st.setInt(col++, modelo.getPorcentaje());
            st.setString(col++, modelo.getDocumento());
            st.setDate(col++, new Date(modelo.getCreado_el().getTime()));
            st.setDate(col++, new Date(modelo.getActualizado_el().getTime()));
            st.setInt(col++, modelo.getId());
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
    public void modificar(Bitacora modelo) throws DAOException {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(UPDATE);
            int col = 1;
            st.setString(col++, modelo.getId_incidente());
            st.setInt(col++, modelo.getUsuario());
            st.setString(col++, modelo.getBitacoracol());
            st.setString(col++, modelo.getRazonRechazo());
            st.setInt(col++, modelo.getPorcentaje());
            st.setString(col++, modelo.getDocumento());
            st.setDate(col++, new Date(modelo.getCreado_el().getTime()));
            st.setDate(col++, new Date(modelo.getActualizado_el().getTime()));
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
    public void eliminar(Bitacora modelo) throws DAOException {
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
    
    private Bitacora convertir(ResultSet rs) throws SQLException{
        return new Bitacora(
                rs.getInt("id"),
                rs.getString("id_incidente"),
                rs.getInt("usuario"),
                rs.getString("bitacoracol"),
                rs.getString("razon_rechazo"),
                rs.getInt("porcentaje"),
                rs.getString("documento"),
                rs.getDate("creado_el"),
                rs.getDate("actualizado_el")
        );
    }

    @Override
    public List<Bitacora> obtenerTodos() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Bitacora> bitacoras = new ArrayList<>();
        
        try {
            stat = conn.prepareStatement(GETALL);
            rs= stat.executeQuery();
            while(rs.next()){
                bitacoras.add(convertir(rs));
            }
        } catch (SQLException e) {
            if(rs !=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MysqlBitacoraDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(stat !=null){
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MysqlBitacoraDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            throw new DAOException("Error al ejecutar el SQL",e);
        }
         return bitacoras;
    }

    @Override
    public Bitacora obtener(Integer id) throws DAOException {
        PreparedStatement stat = null;
         ResultSet rs = null;
         Bitacora bitacora = null;
         try {
            stat = conn.prepareStatement(GETONE);
            stat.setInt(1, id);
            rs= stat.executeQuery();
            if(rs.next()){
                bitacora = convertir(rs);
            }else{
                throw new DAOException("No se ha encontrado registro con el id=" + id);               
            }
        } catch (SQLException e) {
            if(rs !=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MysqlBitacoraDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(stat !=null){
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MysqlBitacoraDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            throw new DAOException("Error al ejecutar el SQL",e);
        }
         return bitacora;
    }
    
}
