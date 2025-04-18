package org.example.Controller;

import org.example.Mod.Direcciones;
import org.example.Mod.DireccionesDAO;
import org.example.Mod.User;
import org.example.Mod.UserDao;

import java.util.HashMap;
import java.util.List;


public class UserController {

    private DireccionesDAO direccionesDAO;
    private UserDao dao;

    public UserController() {
        dao = new UserDao();
        direccionesDAO = new DireccionesDAO();
    }

    public void  agregardireccion (Direcciones direcciones){
        direccionesDAO.insertarDireccion(direcciones);
    }

    public void agregarUsuario(User user){
        dao.insertar(user);
    }

    public List<Direcciones> listarDirecciones(){
        return direccionesDAO.obtenerDirecciones();
    }

    public List<User> listarUsuarios() {
        return dao.obtenerTodos();
    }

    public void actualizarUsuario(String nuevoNombre,String nuevoApellido,int nuevaEdad, String nuevoMail) {
        dao.actualizar(new User(nuevoNombre, nuevoApellido ,nuevaEdad, nuevoMail));
    }


    public void eliminarUsuario(int id) {
        dao.eliminar(id);
    }

    public HashMap<Integer,Direcciones> listarUsuariosDirecciones(){
        return dao.mostrarDirecciones();
    }

    public User mostrarUserPorID(int id){
        return dao.alumnoPorId(id);
    }
}

