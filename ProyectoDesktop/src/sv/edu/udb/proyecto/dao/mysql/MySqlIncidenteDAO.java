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
import java.util.stream.Collectors;
import sv.edu.udb.proyecto.Sesion;
import sv.edu.udb.proyecto.dao.IncidenteDAO;
import sv.edu.udb.proyecto.dao.exception.DAOException;
import sv.edu.udb.proyecto.modelo.Departamento;
import sv.edu.udb.proyecto.modelo.Incidente;

/**
 *
 * @author Ozkar
 */
public class MySqlIncidenteDAO implements IncidenteDAO {

    Connection conn;

    final String INSERT = "INSERT INTO incidente(nombre,descripcion,desarrollador,probador,fecha_creacion,estado,id_proyecto,codigo,detalle_caso,fecha_entrega) VALUES(?,?,?,?,?,?,?,?,?,?)";
    final String UPDATE = "UPDATE incidente SET nombre=?,descripcion=?,desarrollador=?,probador=?,fecha_creacion=?,estado=?,id_proyecto=?,codigo=?,detalle_caso=?,fecha_entrega=? WHERE id=?";
    final String DELETE = "DELETE FROM incidente WHERE id=?";
    final String GETALL = "SELECT id,nombre,descripcion,desarrollador,probador,fecha_creacion,estado,id_proyecto,codigo,detalle_caso,fecha_entrega FROM incidente";
    final String GETONE = "SELECT id,nombre,descripcion,desarrollador,probador,fecha_creacion,estado,id_proyecto,codigo,detalle_caso,fecha_entrega FROM incidente WHERE id=?";

    public MySqlIncidenteDAO(Connection conn) {
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
            st.setString(col++, modelo.getCodigo());
            st.setString(col++, modelo.getDetalleCaso());
            if (modelo.getFechaEntrega() != null) {
                st.setDate(col++, new Date(modelo.getFechaEntrega().getTime()));
            } else {
                st.setDate(col++, null);
            }
            if (st.executeUpdate() < 0) {
                throw new DAOException("Fallo al ejecutar el statement, no se pudo insertar  " + modelo.toString());
            }
        } catch (SQLException e) {
            System.out.println(e);
            throw new DAOException("No se pudo insertar  " + modelo.toString(), e);
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                throw new DAOException("Fallo en el Statement, no se pudo insertar  " + modelo.toString(), e);
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
            st.setString(col++, modelo.getCodigo());
            st.setString(col++, modelo.getDetalleCaso());
            st.setDate(col++,((modelo.getFechaEntrega()!=null)
                    ?new Date(modelo.getFechaEntrega().getTime())
                    :null)
                    );
            st.setInt(col++, modelo.getId());
            if (st.executeUpdate() < 0) {
                throw new DAOException("Fallo al ejecutar el statement, no se pudo insertar  " + modelo.toString());
            }
        } catch (SQLException e) {
            throw new DAOException("No se pudo insertar  " + modelo.toString(), e);
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                throw new DAOException("Fallo en el Statement, no se pudo insertar  " + modelo.toString(), e);
            }
        }
    }

    @Override
    public void eliminar(Incidente modelo) throws DAOException {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(DELETE);
            int col = 1;
            st.setInt(col++, modelo.getId());
            if (st.executeUpdate() < 0) {
                throw new DAOException("Fallo al ejecutar el statement, no se pudo borrar " + modelo.toString());
            }
        } catch (SQLException e) {
            throw new DAOException("No se pudo borrar " + modelo.toString(), e);
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                throw new DAOException("Fallo en el Statement, no se pudo borrar " + modelo.toString(), e);
            }
        }
    }

    private Incidente convertir(ResultSet rs) throws SQLException {
        return new Incidente(
                rs.getInt("id"),
                rs.getString("nombre"),
                rs.getString("descripcion"),
                rs.getInt("desarrollador"),
                rs.getInt("probador"),
                rs.getDate("fecha_creacion"),
                rs.getInt("estado"),
                rs.getInt("id_proyecto"),
                rs.getString("codigo"),
                rs.getString("detalle_caso"),
                rs.getDate("fecha_entrega")
        );
    }

    @Override
    public List<Incidente> obtenerTodos() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Incidente> incidentes = new ArrayList<>();

        try {
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                incidentes.add(convertir(rs));
            }
        } catch (SQLException e) {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySqlIncidenteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySqlIncidenteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            throw new DAOException("Error al ejecutar el SQL", e);
        }
        return incidentes;
    }

    @Override
    public Incidente obtener(Integer id) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Incidente incidente = null;
        try {
            stat = conn.prepareStatement(GETONE);
            stat.setInt(1, id);
            rs = stat.executeQuery();
            if (rs.next()) {
                incidente = convertir(rs);
            } else {
                throw new DAOException("No se ha encontrado registro con el id=" + id);
            }
        } catch (SQLException e) {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySqlIncidenteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySqlIncidenteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            throw new DAOException("Error al ejecutar el SQL", e);
        }
        return incidente;
    }

    @Override
    public List<Incidente> incidentesByDepartamento(Departamento dep) {
        // TODO  fix this
        try {
            return this.obtenerTodos().stream().filter(inc -> {
                try {
                    int dep_id = Sesion.getDatos().getProyectoDAO().obtener(inc.getIdProyecto()).getDepartamento();
                    return dep_id == dep.getId();
                } catch (SQLException | ClassNotFoundException | DAOException ex) {
                    return false;
                }
            }).collect(Collectors.toList());
        } catch (DAOException ex) {
            Logger.getLogger(MySqlIncidenteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }

    @Override
    public List<Incidente> incidentesByDepartamentoAndEstado(Departamento dep, int estado) {
        //TODO        
        //fix this
        return this.incidentesByDepartamento(dep).stream().filter(inc -> inc.getEstado() == estado).collect(Collectors.toList());
    }

    @Override
    public String estadoString(int estado) {
        switch(estado){
            case 1:
                return "Solicitud";
            case 2:
                return "Aprobado";
            case 3:
                return "Rechazado";
            case 4:
                return "En proceso";
            case 5:
                return "En revisión";
            case 6:
                return "Finalizado";
            case 7:
                return "Devuelto";
            case 8:
                return "Caducado";
            default:
                return "Desconocido";            
        }
    }

}
