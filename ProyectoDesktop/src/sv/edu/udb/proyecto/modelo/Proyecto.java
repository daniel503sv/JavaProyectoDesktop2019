/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.proyecto.modelo;

/**
 *
 * @author josed
 */
public class Proyecto implements BaseModel{
    private Integer id;
    private String nombre;
    private String descripcion;
    private Integer departamento;
    private String documento;
    private Integer encargado;
    public static final String[] HEADERS = {"ID","Nombre","Descripción","Departamento","Documento","Encargado"};

    public Proyecto() {
    }

    public Proyecto(String nombre, String descripcion, int departamento, String documento, int encargado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.departamento=departamento;
        this.documento=documento;
        this.encargado=encargado;
    }

    public Proyecto(int id, String nombre, String descripcion, int departamento, String documento, int encargado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.departamento=departamento;
        this.documento=documento;
        this.encargado=encargado;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    
    public int getDepartamento(){
        return departamento;
    }
    
    public void setDepartamento(int departamento){
        this.departamento=departamento;
    }
    
    public String getDocumento(){
        return documento;
    }
    
    public void setDocumento(String documento){
        this.documento=documento;
    }
    
    public int getEncargado(){
        return encargado;
    }
    
    public void setEncargado(int encargado){
        this.encargado=encargado;
    }

    @Override
    public String toString() {
        return "Proyecto{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion +
                "departamento=" + departamento + "documento=" + documento + "encargado=" + encargado + "}";
    }

    @Override
    public Object[] getData() {
        Object[] data = {this.id,this.nombre,this.descripcion,this.departamento,this.documento,this.encargado};
        return data;
    }   
}
