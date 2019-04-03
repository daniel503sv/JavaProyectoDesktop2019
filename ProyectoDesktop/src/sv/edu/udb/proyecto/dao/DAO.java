/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.proyecto.dao;

import java.util.List;
import sv.edu.udb.proyecto.dao.exception.DAOException;
/**
 *
 * @author josed
 */

//T objeto modelo
//K id del modelo
public interface DAO<T,K> {
    void insertar(T modelo) throws DAOException;
    void modificar(T modelo) throws DAOException;
    void eliminar(T modelo) throws DAOException;
    List<T> obtenerTodos() throws DAOException;
    T obtener(K id) throws DAOException;
}
