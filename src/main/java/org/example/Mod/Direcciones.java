package org.example.Mod;

public class Direcciones {
    private String calle;
    private int altura;
    private int alumno_id;


    public Direcciones(){
        this.calle = "";
        this.altura = 0;
        this.alumno_id = 0;
    }

    public Direcciones(String calle, int altura, int alumno_id) {
        this.calle = calle;
        this.altura = altura;
        this.alumno_id = alumno_id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getAlumno_id() {
        return alumno_id;
    }

    public void setAlumno_id(int alumno_id) {
        this.alumno_id = alumno_id;
    }

    public void mostrarSimple(){
        System.out.println("Calle:"+getCalle());
        System.out.println("Altura:"+getAltura());
        System.out.println("Alumno ID: "+getAlumno_id());
    }

    @Override
    public String toString() {
        return "Direcciones{" +
                "calle='" + calle + '\'' +
                ", altura=" + altura +
                ", alumno_id=" + alumno_id +
                '}';
    }
}
