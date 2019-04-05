package sv.edu.udb.proyecto.modelo;

import java.util.Date;

/**
 *
 * @author Ozkar
 */
public class Incidente implements BaseModel {
    private int id;
    private String nombre;
    private String descripcion;
    private int desarrollador;
    private int probador;
    private Date fechaCreacion;
    private int estado;
    private int idProyecto;
    private String codigo;
    private String detalleCaso;
    private Date fechaEntrega;
    public static final String[] HEADERS = {"ID","Nombre","Descripción","Desarrollador","Probador","Fecha de creación","Estado","Proyecto"};
    
    public Incidente(){
        this.fechaCreacion=new Date();
    }
    
    public Incidente(String nombre,String descripcion,int desarrollador,int probador,Date fechaCreacion,int estado, int idProyecto,String codigo,String detalleCaso,Date fechaEntrega){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.desarrollador = desarrollador;
        this.probador = probador;
        this.fechaCreacion = new Date();
        this.estado = estado;
        this.idProyecto = idProyecto;
        this.codigo = codigo;
        this.detalleCaso = detalleCaso;
        this.fechaEntrega = fechaEntrega;
    }
    
    public Incidente(int id, String nombre,String descripcion,int desarrollador,int probador,Date fechaCreacion,int estado, int idProyecto,String codigo,String detalleCaso,Date fechaEntrega){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.desarrollador = desarrollador;
        this.probador = probador;
        this.fechaCreacion = new Date();
        this.estado = estado;
        this.idProyecto = idProyecto;
        this.codigo = codigo;
        this.detalleCaso = detalleCaso;
        this.fechaEntrega = fechaEntrega;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDetalleCaso() {
        return detalleCaso;
    }

    public void setDetalleCaso(String detalleCaso) {
        this.detalleCaso = detalleCaso;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
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
