package org.example.Mod;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DireccionesDAO {

    private Connection conn;

    public DireccionesDAO() {
        this.conn = ConexionMySql.conectar();
    }


    private void crearTablaSiNoExiste() {
        String sql = "CREATE TABLE IF NOT EXISTS direcciones(id int primary key auto_increment,calle varchar(50),altura integer,alumno_id integer)";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("error creando la tabla: " + e.getMessage());
        }

    }

    public void insertarDireccion(Direcciones direcciones) {
        String sql = "INSERT INTO direcciones (calle,altura,alumno_id) Values(?,?,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, direcciones.getCalle());
            pstmt.setInt(2, direcciones.getAltura());
            pstmt.setInt(3, direcciones.getAlumno_id());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error insertando direeciones: " + e.getMessage());
        }
    }

    public List<Direcciones> obtenerDirecciones(){

        List<Direcciones> listadirec = new ArrayList<>();
        String sql = "SELECT * FROM direcciones";

        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            {
    while( rs.next()){
        Direcciones d = new Direcciones(rs.getString("calle"), rs.getInt("altura"), rs.getInt("alumno_id"));
        listadirec.add(d);
    }
}
        }catch (SQLException e){
            System.out.println("Error leyendo direcciones :" + e.getMessage());
        }
return listadirec;

    }

}