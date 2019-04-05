package sv.edu.udb.proyecto.modelo;

import java.sql.Date;

/**
 *
 * @author Ozkar
 */
public class Bitacora implements BaseModel {
    private Integer id;
    private Integer id_incidente;
    private int usuario;
    private int porcentaje;
    private String documento;
    private Date creado_el;
    private Date actualizado_el;
    private String detalle;
    public static final String[] HEADERS = {"ID","ID Incidente","Usuario","Bitacora","Razón de rechazo","Porcentaje","Documento","Creado","Actualizado"};
    
    @Override
    public Object[] getData(){
        Object [] data = {this.id,this.id_incidente,this.usuario,this.porcentaje,this.documento,
        this.creado_el,this.actualizado_el};
        return data;
    }
    public Bitacora(){
    
    }
    
    public Bitacora(String detalle,int id_incidente,int usuario,int porcentaje,String documento,Date creado_el, Date actualizado_el){
        this.id_incidente = id_incidente;
        this.usuario = usuario;      
        this.porcentaje = porcentaje;
        this.documento = documento;
        this.creado_el = creado_el;
        this.actualizado_el = actualizado_el;
        this.detalle = detalle;

    }
    
    public Bitacora(Integer id,String detalle, int id_incidente,int usuario,int porcentaje,String documento,Date creado_el, Date actualizado_el){
        this.id = id;
        this.id_incidente = id_incidente;
        this.usuario = usuario;
        this.porcentaje = porcentaje;
        this.documento = documento;
        this.creado_el = creado_el;
        this.actualizado_el = actualizado_el;
        this.detalle = detalle;
        
    }
    
    public Integer getId() {
        return id;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    
    

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_incidente() {
        return id_incidente;
    }

    public void setId_incidente(int id_incidente) {
        this.id_incidente = id_incidente;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }
     
    public int getPorcentaje() {
        return porcentaje;
    }
    
    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
    
    public String getDocumento() {
        return documento;
    }
    
    public void setDocumento(String documento) {
        this.documento = documento;
    }
    
    public Date getCreado_el() {
        return creado_el;
    }
    
    public void setCreado_el(Date creado_el) {
        this.creado_el = creado_el;
    }
    
    public Date getActualizado_el() {
        return actualizado_el;
    }
    
    public void setActualizado_el(Date actualizado_el) {
        this.actualizado_el = actualizado_el;
    }
    
   
    
   
}
