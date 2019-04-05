package sv.edu.udb.proyecto.modelo;

import java.sql.Date;

/**
 *
 * @author Ozkar
 */
public class Incidente implements BaseModel {
    private String id;
    private String nombre;
    private String descripcion;
    private int desarrollador;
    private int probador;
    private Date fechaCreacion;
    private int estado;
    private int idProyecto;
    public static final String[] HEADERS = {"ID","Nombre","Descripción","Desarrollador","Probador","Fecha de creación","Estado","ID proyecto"};
    
    public Incidente(){
    
    }
    
    public Incidente(String nombre,String descripcion,int desarrollador,int probador,Date fechaCreacion,int estado, int idProyecto){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.desarrollador = desarrollador;
        this.probador = probador;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
        this.idProyecto = idProyecto;
    }
    
    public Incidente(String id, String nombre,String descripcion,int desarrollador,int probador,Date fechaCreacion,int estado, int idProyecto){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.desarrollador = desarrollador;
        this.probador = probador;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
        this.idProyecto = idProyecto;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
   
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public int getDesarrollador() {
        return desarrollador;
    }
    
    public void setDesarrollador(int desarrollador) {
        this.desarrollador = desarrollador;
    }
    
    public int getProbador() {
        return probador;
    }
   
    public void setProbador(int probador) {
        this.probador = probador;
    }
    
    public Date getFechaCreacion() {
        return fechaCreacion;
    }
    
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    public int getEstado() {
        return estado;
    }
    
    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    public int getIdProyecto() {
        return idProyecto;
    }
   
    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }
    
    @Override
    public String toString(){
    return "Incidente{" + "id = " +id+ " nombre = " +nombre+ " descripcion = " +descripcion+ " desarrollador = " +desarrollador
            +" probador = "+probador +" fecha de creacion = "+fechaCreacion + " estado = "+estado +" id proyecto = "+idProyecto+'}';
    }
    
    @Override
    public Object[] getData(){
        Object [] data = {this.id,this.nombre,this.descripcion,this.desarrollador,this.probador,this.fechaCreacion,this.estado,this.idProyecto};
        return data;
    }
}
