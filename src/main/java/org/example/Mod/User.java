package org.example.Mod;

public class User {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String email;

    public User(){
        this.id = 0;
        this.nombre = "";
        this.apellido = "";
        this.edad = 0;
        this.email = "";
    }

    public User(String apellido, String nombre) {
        this.apellido = apellido;
        this.nombre = nombre;
    }

    public User (int id,String nombre, String apellido, int edad, String email){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.email = email;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void mostrarSimple(){
        System.out.println("Nombre: "+getNombre());
        System.out.println("Apellido: "+getApellido());
    }

    @Override
    public String toString() {
        return "User{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", email='" + email + '\'' +
                '}';
    }
}
