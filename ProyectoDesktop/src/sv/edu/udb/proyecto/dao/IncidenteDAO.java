package sv.edu.udb.proyecto.dao;
import java.util.List;
import sv.edu.udb.proyecto.modelo.Departamento;
import sv.edu.udb.proyecto.modelo.Incidente;
/**
 *
 * @author Ozkar
 */
public interface IncidenteDAO extends DAO<Incidente,Integer>{
    public List<Incidente> incidentesByDepartamento(Departamento dep);
    public List<Incidente> incidentesByDepartamentoAndEstado(Departamento dep,int estado);
    public String estadoString(int estado);
}
