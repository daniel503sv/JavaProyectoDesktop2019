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
import java.util.logging.Level;
import java.util.logging.Logger;
import sv.edu.udb.proyecto.dao.DAOManager;
import sv.edu.udb.proyecto.dao.DepartamentoDAO;
import sv.edu.udb.proyecto.dao.RolDAO;
import sv.edu.udb.proyecto.dao.UsuarioDAO;
import sv.edu.udb.proyecto.dao.ProyectoDAO;

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
    
    @Override
    public void close(){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySqlDAOManager.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
}
