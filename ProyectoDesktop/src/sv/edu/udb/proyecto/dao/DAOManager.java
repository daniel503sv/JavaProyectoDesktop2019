/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.proyecto.dao;

/**
 *
 * @author josed
 */
public interface DAOManager {

    UsuarioDAO getUsuarioDAO();
    RolDAO getRolDAO();
    DepartamentoDAO getDepartamentoDAO();
    ProyectoDAO getProyectoDAO();
    BitacoraDAO getBitacoraDAO();
    ComentarioDAO getComentarioDAO();
    IncidenteDAO getIncidenteDAO();
    void close();
}
