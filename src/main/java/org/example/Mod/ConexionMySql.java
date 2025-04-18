package org.example.Mod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionMySql {

        // Parámetros de conexión a MySQL
        private static final String URL = "jdbc:mysql://172.16.1.64:3306/";
        private static final String DB_NAME = "practicajdbc2";
        private static final String USER = "bdd1";
        private static final String PASS = "bdd1";

        static {
            crearBaseSiNoExiste();
        }

        // Este método se encarga de crear la base de datos si no existe
        private static void crearBaseSiNoExiste() {
            try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
                 Statement stmt = conn.createStatement()) {
                stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS " + DB_NAME);
            } catch (SQLException e) {
                System.out.println("Error creando base de datos: " + e.getMessage());
            }
        }

        // Retorna una conexión a la base de datos ya creada
        public static Connection conectar() {
            try {
                return DriverManager.getConnection(URL + DB_NAME + "?useSSL=false&serverTimezone=UTC", USER, PASS);
            } catch (SQLException e) {
                System.out.println("Error al conectar: " + e.getMessage());
                return null;
            }
        }
}
