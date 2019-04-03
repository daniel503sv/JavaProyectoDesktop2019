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
public class Departamento implements BaseModel{
    private Integer id;
    private String nombre;
    private String descripcion;
    public static final String[] HEADERS = {"ID","Nombre","Descripción"};

    public Departamento() {
    }

    public Departamento(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Departamento(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
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

    @Override
    public String toString() {
        return "Departamento{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }

    @Override
    public Object[] getData() {
        Object[] data = {this.id,this.nombre,this.descripcion};
        return data;
    }   
}
