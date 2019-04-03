/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.proyecto.modelo;

import java.util.Date;

/**
 *
 * @author josed
 */
public class Usuario implements BaseModel{
    int id;
    String nombre;
    String apellido;
    String correo;
    String password;
    String telefono;
    Integer departamentoId;
    Integer rolId;
    Date fechaCreacion;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String correo, String telefono, int departamentoId, int rolId) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.departamentoId = departamentoId;
        this.rolId = rolId;
        this.fechaCreacion = new Date();
    }

    public Usuario(int id, String nombre, String apellido, String correo, String telefono, int departamentoId, int rolId, Date fechaCreacion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.departamentoId = departamentoId;
        this.rolId = rolId;
        this.fechaCreacion = fechaCreacion;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(int departamentoId) {
        this.departamentoId = departamentoId;
    }

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", password=" + password + ", telefono=" + telefono + ", departamentoId=" + departamentoId + ", rolId=" + rolId + ", fechaCreacion=" + fechaCreacion + '}';
    }    

    @Override
    public Object[] getData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
