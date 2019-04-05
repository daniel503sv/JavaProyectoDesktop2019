package sv.edu.udb.proyecto.modelo;
import java.sql.Date;

/**
 *
 * @author Ozkar
 */
public class Comentario implements BaseModel {
    private Integer id;
    private String nombre;
    private String descripcion;
    private int usuario;
    private int bitacora_id;
    private Date creado_el;
    public static final String[] HEADERS = {"ID","Nombre","Descripción","Usuario","ID Bitácora","Fecha creación"};
    
    public Comentario(){
    
    }
    
    public Comentario(String nombre, String descripcion, int usuario, int bitacora_id, Date creado_el){
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.usuario = usuario;
    this.bitacora_id = bitacora_id;
    this.creado_el = creado_el;
    
    }
    
    public Comentario(int id, String nombre, String descripcion, int usuario, int bitacora_id, Date creado_el){
    this.id = id;    
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.usuario = usuario;    
    this.bitacora_id = bitacora_id;
    this.creado_el = creado_el;
    
    }
    
    public Integer getId() {
        return id;
    }
   
    public void setId(Integer id) {
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
    
    public int getUsuario() {
        return usuario;
    }
    
    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }
    
    public int getBitacora_id() {
        return bitacora_id;
    }
    
    public void setBitacora_id(int bitacora_id) {
        this.bitacora_id = bitacora_id;
    }
    
    public Date getCreado_el() {
        return creado_el;
    }
    
    public void setCreado_el(Date creado_el) {
        this.creado_el = creado_el;
    }
    
    @Override
    public String toString(){
        return "Comentario{" + "id = " + id + " nombre = " + nombre + " descripcion = "+ descripcion + " usuario = " 
                + usuario + " id bitacora = " + bitacora_id + "fecha de creacion = " + creado_el +'}';
    }
    @Override
    public Object[] getData(){
        Object[] data ={this.id,this.nombre,this.descripcion,this.usuario,this.bitacora_id,this.creado_el};
        return data;
    }
}
