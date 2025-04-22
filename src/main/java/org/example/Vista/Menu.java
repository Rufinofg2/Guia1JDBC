package org.example.Vista;
import org.example.Controller.UserController;
import org.example.Mod.Direcciones;
import org.example.Mod.User;

import java.util.*;

public class Menu {


    private final UserController controller;
    private final Scanner scanner;

    public Menu() {
        controller = new UserController();
        scanner = new Scanner(System.in);
    }

    public void mostrar() {
        int opcion;
        do {
            System.out.println("\n--- MENÚ USUARIOS ---");
            System.out.println("1. Agregar usuario");
            System.out.println("2. Agregar Direccion");
            System.out.println("3. Listar direccion");
            System.out.println("4. Listar alumnos");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpia el buffer del scanner

            switch (opcion) {
                case 1 -> agregarAlumno();
                case 2 -> agregarDireccion();
                case 3 -> listarDireccion();
                case 4 -> listar();
                case 5 -> listarUsuariosDirecciones();///  aLUMNOS
                case 0 -> System.out.println("¡Chau!");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 0);
    }

    private void agregarAlumno() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.printf("Edad:");
        int edad = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Email: ");
        String email = scanner.nextLine();
        User user = new User(nombre,apellido,edad,email);
        controller.agregarUsuario(user);

    }

    public void agregarDireccion() {
        System.out.println("Callle: ");
        String calle = scanner.nextLine();
        System.out.println("Altura: ");
        int altura = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Alumno id");
        int alumno_id = scanner.nextInt();
        scanner.nextLine();
        Direcciones direcciones = new Direcciones(calle,altura,alumno_id);
        controller.agregardireccion(direcciones);
    }

    private void listarDireccion(){
        List<Direcciones> direccionesList = controller.listarDirecciones();
        direccionesList.forEach(System.out::println);
    }

    private void listar() {
        List<User> usuarios = controller.listarUsuarios();
        usuarios.forEach(System.out::println);
    }

    private void actualizar() {
        System.out.print("Nuevo nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("ID a modificar: ");
        int edad = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nuevo nombre: ");
        String email = scanner.nextLine();
        controller.actualizarUsuario(nombre,apellido, edad,email);
    }

    private void eliminar() {
        System.out.print("ID a eliminar: ");
        int id = scanner.nextInt();
        controller.eliminarUsuario(id);
    }

    public void listarUsuariosDirecciones(){
        HashMap<Integer,Direcciones> listaAlumos = controller.listarUsuariosDirecciones();
        mostrarListaCompleta(listaAlumos);
    }

    private void mostrarLista(List<User> lista){
        Iterator<User> iterador = lista.iterator();
        while(iterador.hasNext()){
            System.out.println(iterador.next());
        }
    }

    private void mostrarListaCompleta(HashMap<Integer, Direcciones> mapa){
        User alumno = new User();
        for (Map.Entry<Integer, Direcciones> entrada : mapa.entrySet()) {
            Integer clave = entrada.getKey();
            alumno = controller.mostrarUserPorID(clave);
            Direcciones direccion = entrada.getValue();
            alumno.mostrarSimple();
            System.out.println("Direcciones: ");
            direccion.mostrarSimple();
            System.out.println("\n");
        }
    }
}

