package org.example.Mod;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.sql.Connection;

public class UserDao {
    private Connection conn;

    public UserDao() {
        this.conn = ConexionMySql.conectar();
    }

    private void crearTablaSiNoExiste() {
        String sql = "CREATE TABLE IF NOT EXISTS alumnos (id INT PRIMARY KEY AUTO_INCREMENT, nombre VARCHAR(100),apellido varchar(50),edad INTEGER,email varchar(100))";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Error creando tabla: " + e.getMessage());
        }
    }

    // Inserta un nuevo usuario
    public void insertar(User user) {
        String sql = "INSERT INTO alumnos(nombre,apellido,edad,email) VALUES(?,?,?,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getNombre());
            pstmt.setString(2, user.getApellido());
            pstmt.setInt(3, user.getEdad());
            pstmt.setString(4, user.getEmail());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error insertando usuario: " + e.getMessage());
        }
    }

    // Devuelve la lista de usuarios existentes
    public List<User> obtenerTodos() {
        List<User> lista = new ArrayList<>();
        String sql = "SELECT * FROM alumnos";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                User u = new User(rs.getString("nombre"), rs.getString("apellido"), rs.getInt("edad"), rs.getString("email"));
                lista.add(u);
            }
        } catch (SQLException e) {
            System.out.println("Error leyendo usuarios: " + e.getMessage());
        }

        return lista;
    }

    // Actualiza un usuario existente
    public void actualizar(User user) {
        String sql = "UPDATE usuarios SET nombre = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getNombre());
            pstmt.setInt(2, user.getEdad());
            pstmt.setString(3, user.getEmail());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error actualizando usuario: " + e.getMessage());
        }
    }

    public HashMap<Integer, Direcciones> mostrarDirecciones() {
        String sql = "SELECT d.calle as nombreCalle, d.altura as alturaCalle, d.alumno_id as alumno from direcciones as d join alumnos as a where d.alumno_id=a.id";
        HashMap<Integer, Direcciones> mapaDirecciones = new HashMap<>();
        try (Statement statement = conn.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                Direcciones direcciones = new Direcciones(rs.getString("nombreCalle"), rs.getInt("alturaCalle"), rs.getInt("alumno"));
                mapaDirecciones.put(direcciones.getAlumno_id(), direcciones);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return mapaDirecciones;


    }


    public User alumnoPorId(int id) {
        User alumno = null;
        String sql = "SELECT * FROM alumnos WHERE id=" + id;
        try (Statement stm = conn.createStatement()) {
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                alumno = new User(rs.getString("nombre"), rs.getString("apellido"), rs.getInt("edad"), rs.getString("email"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alumno;



    }
    // Elimina un usuario por su ID
    public void eliminar ( int id){
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error eliminando usuario: " + e.getMessage());
        }
    }

}

