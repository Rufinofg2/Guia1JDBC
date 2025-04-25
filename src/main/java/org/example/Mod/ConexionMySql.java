package org.example.Mod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionMySql {

    // Parámetros de conexión a MySQL
    private static final String URL = "jdbc:mysql://172.16.1.64:3306/practicajdbc2";
    private static final String USER = "bdd1";
    private static final String PASS = "bdd1";
    private static ConexionMySql instancia;
    private Connection conn;

    public ConexionMySql(){
        try {
            conn = DriverManager.getConnection(URL,USER,PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ConexionMySql getInstance(){
        if(instancia==null){
            instancia = new ConexionMySql();
        }
        return instancia;
    }


    public Connection getConexion(){
        return conn;
    }




}