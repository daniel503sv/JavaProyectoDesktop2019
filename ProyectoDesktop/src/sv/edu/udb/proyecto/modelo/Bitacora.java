package sv.edu.udb.proyecto.modelo;

import java.sql.Date;

/**
 *
 * @author Ozkar
 */
public class Bitacora implements BaseModel {
    private Integer id;
    private String id_incidente;
    private int usuario;
    private String bitacoracol;
    private String razonRechazo;
    private int porcentaje;
    private String documento;
    private Date creado_el;
    private Date actualizado_el;
    public static final String[] HEADERS = {"ID","ID Incidente","Usuario","Bitacora","Razón de rechazo","Porcentaje","Documento","Creado","Actualizado"};
    
    public Bitacora(){
    
    }
    
    public Bitacora(String id_incidente,int usuario,String bitacoracol,String razonRechazo,int porcentaje,String documento,Date creado_el, Date actualizado_el){
        this.id_incidente = id_incidente;
        this.usuario = usuario;
        this.bitacoracol = bitacoracol;
        this.razonRechazo = razonRechazo;
        this.porcentaje = porcentaje;
        this.documento = documento;
        this.creado_el = creado_el;
        this.actualizado_el = actualizado_el;
        
    }
    
    public Bitacora(Integer id, String id_incidente,int usuario,String bitacoracol,String razonRechazo,int porcentaje,String documento,Date creado_el, Date actualizado_el){
        this.id = id;
        this.id_incidente = id_incidente;
        this.usuario = usuario;
        this.bitacoracol = bitacoracol;
        this.razonRechazo = razonRechazo;
        this.porcentaje = porcentaje;
        this.documento = documento;
        this.creado_el = creado_el;
        this.actualizado_el = actualizado_el;
        
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getId_incidente() {
        return id_incidente;
    }

    public void setId_incidente(String id_incidente) {
        this.id_incidente = id_incidente;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public String getBitacoracol() {
        return bitacoracol;
    }
    
    public void setBitacoracol(String bitacoracol) {
        this.bitacoracol = bitacoracol;
    }

    public String getRazonRechazo() {
        return razonRechazo;
    }

    public void setRazonRechazo(String razonRechazo) {
        this.razonRechazo = razonRechazo;
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
    
    @Override
    public String toString(){
        return "Bitacora{" + "id = " +id +" id incidente = " +id_incidente + " usuario = " +usuario +" bitacoracol = " +bitacoracol
                + " razon de rechazo = " +razonRechazo + " porcentaje = " +porcentaje +" documento = " +documento 
                +" creado = " +creado_el + " actualizado = "+actualizado_el +'}';
    }
    
    @Override
    public Object[] getData(){
        Object [] data = {this.id,this.id_incidente,this.usuario,this.bitacoracol,this.razonRechazo,this.porcentaje,this.documento,
        this.creado_el,this.actualizado_el};
        return data;
    }
}
