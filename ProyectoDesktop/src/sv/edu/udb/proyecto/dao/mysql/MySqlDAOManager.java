/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.proyecto.dao.mysql;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import sv.edu.udb.proyecto.dao.DAOManager;
import sv.edu.udb.proyecto.dao.DepartamentoDAO;
import sv.edu.udb.proyecto.dao.RolDAO;
import sv.edu.udb.proyecto.dao.UsuarioDAO;
import sv.edu.udb.proyecto.dao.ProyectoDAO;
import sv.edu.udb.proyecto.dao.BitacoraDAO;
import sv.edu.udb.proyecto.dao.ComentarioDAO;
import sv.edu.udb.proyecto.dao.IncidenteDAO;

/**
 *
 * @author josed
 */
public class MySqlDAOManager implements DAOManager {

    private Connection conn;
    private String host;
    private String username;
    private String password;
    private String database;

    private UsuarioDAO usuarios= null;
    private RolDAO roles = null;
    private DepartamentoDAO departamentos= null;
    private ProyectoDAO proyectos=null;
    private IncidenteDAO incidentes=null;
    private BitacoraDAO bitacoras=null;
    private ComentarioDAO comentarios=null;
    
    
    public MySqlDAOManager() throws SQLException, FileNotFoundException, IOException, ClassNotFoundException {
        String rootPath = "classpath:/resources/";
        String appConfigPath = rootPath + "proyecto.properties";
 
        Properties appProps = new Properties();
        appProps.load(new FileInputStream(appConfigPath));
        
        this.host = appProps.getProperty("host");
        this.username = appProps.getProperty("username");
        this.password = appProps.getProperty("password");
        this.database = appProps.getProperty("database");
        
        Class.forName("com.mysql.jdbc.Driver"); 
        conn = DriverManager.getConnection("jdbc:mysql://"+host+"/"+database, username, password);
    }
    
    public MySqlDAOManager(String host,String username,String password,String database) throws SQLException, ClassNotFoundException {
        this.host = host;
        this.username = username;        
        this.password = password;
        this.database = database;
        Class.forName("com.mysql.jdbc.Driver"); 
        conn = DriverManager.getConnection("jdbc:mysql://"+host+"/"+database, username, password);
    }
    
    @Override
    public UsuarioDAO getUsuarioDAO() {
       if(usuarios==null){
           usuarios = new  MySqlUsuarioDAO(conn);
       }
       return usuarios;
    }

    @Override
    public RolDAO getRolDAO() {
     if(roles==null){
           roles = new  MySqlRolDAO(conn);
       }
       return roles;    
    }

    @Override
    public DepartamentoDAO getDepartamentoDAO() {
     if(departamentos==null){
           departamentos = new  MySqlDepartamentoDAO(conn);
       }
       return departamentos;    
    }

    @Override
    public ProyectoDAO getProyectoDAO() {
     if(proyectos==null){
           proyectos = new  MySqlProyectoDAO(conn);
       }
       return proyectos;    
    }
    
    @Override
    public IncidenteDAO getIncidenteDAO() {
     if(incidentes==null){
           incidentes = new  MySqlIncidenteDAO(conn);
       }
       return incidentes;    
    }
    
    @Override
    public BitacoraDAO getBitacoraDAO() {
     if(bitacoras==null){
           bitacoras = new  MySqlBitacoraDAO(conn);
       }
       return bitacoras;    
    }
    
    @Override
    public ComentarioDAO getComentarioDAO() {
     if(comentarios==null){
           comentarios = new  MySqlComentarioDAO(conn);
       }
       return comentarios;    
    }
    
}
